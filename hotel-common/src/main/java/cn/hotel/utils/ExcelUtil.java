package cn.hotel.utils;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-17 12:40
 */
public class ExcelUtil {


    /**
     *
     * @param list        数据
     * @param o           解析对象属性名
     * @param pathFile    文件位置
     * @param SheetName   表名
     */
    public static void SXSSFExcel(List<Object> list,Object o,String pathFile,String SheetName){
        long startTime = System.currentTimeMillis();
        SXSSFWorkbook sxssfWorkbook = null;
        BufferedOutputStream outputStream = null;

        /**
         * 获取所有属性列
         */
        List<Object> objectName =new ArrayList<>();
        try {
            objectName = ReflexUtil.getObjectName(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //这样表示SXSSFWorkbook只会保留100条数据在内存中，其它的数据都会写到磁盘里，这样的话占用的内存就会很少
            sxssfWorkbook = new SXSSFWorkbook(getXSSFWorkbook(pathFile,SheetName),100);
            //获取第一个Sheet页
            SXSSFSheet sheet = sxssfWorkbook.getSheetAt(0);

            SXSSFRow row = sheet.createRow(0);
            for (int j = 0; j < objectName.size(); j++) {
                row.createCell(j).setCellValue(objectName.get(j).toString());
            }
            for (int z = 0; z < list.size(); z++) {
                SXSSFRow row1 = sheet.createRow(z+1);
                List<Object> objectValue = ReflexUtil.getObjectValue(list.get(z));
                for (int j = 0; j <objectValue.size(); j++) {
                    row1.createCell(j).setCellValue(objectValue.get(j).toString());
                }
            }
            outputStream = new BufferedOutputStream(new FileOutputStream(pathFile));
            sxssfWorkbook.write(outputStream);
            outputStream.flush();
            sxssfWorkbook.dispose();// 释放workbook所占用的所有windows资源
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
    /**
     * 先创建一个XSSFWorkbook对象
     * @param filePath
     * @return
     */
    public static XSSFWorkbook getXSSFWorkbook(String filePath,String SheetName) {
        XSSFWorkbook workbook =  null;
        BufferedOutputStream outputStream = null;
        try {
            File fileXlsxPath = new File(filePath);
            outputStream = new BufferedOutputStream(new FileOutputStream(fileXlsxPath));
            workbook = new XSSFWorkbook();
            workbook.createSheet(SheetName);
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return workbook;
    }
}