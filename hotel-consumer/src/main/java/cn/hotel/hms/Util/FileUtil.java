package cn.hotel.hms.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileUtil {

    @Value("D://picture//")
    private String logPath;

    public static String getFileName(){
        String str = "";
        File file = new File("");
        try {
            String canonicalPath = file.getCanonicalPath();
            String substring = canonicalPath.substring(0, canonicalPath.lastIndexOf('-'));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(substring);
            stringBuffer.append("-");
            stringBuffer.append("consumer\\src\\main\\resources\\static\\images\\");
            str = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


    public String upload(MultipartFile file, Integer type){
        //上传apk，文件名用原文件名，log 文件名需要重命名
        System.out.println(">>>>>>>>>"+file);
        String fileName=file.getOriginalFilename();
        System.out.println(fileName+"////////");
        String filePath="";
        if (1 == type) {
            //apk
            filePath=getFileName();
        }
//        else{
//            //log
//            //截取源文件名的后缀
//            String suffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
//            //UUID 生成字符串
//            String uuid= UUID.randomUUID().toString().replace("-","");
//            fileName=uuid+suffix;
//            filePath=logPath;
//        }
        //文件上传
        if(file.isEmpty()){
            return "";
        }
        File dest=new File(filePath+fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return fileName;
    }
}
