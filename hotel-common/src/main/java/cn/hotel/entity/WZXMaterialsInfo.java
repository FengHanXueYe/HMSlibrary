package cn.hotel.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:物品详细信息实体类
 *
 * isStockAlam 是否库存警报
 * （ 20>缺少‘2’，50<充足‘0’，0=暂无‘1’）
 *
 * @author: 汪志雄
 * @date: 2019-09-03 16:14
 */
public class WZXMaterialsInfo implements Serializable {
    private Integer materialsId,isStockAlam,supplierNumber,materialsDisable,materialsStatus;
    private String materialsBarCode;
    private String materialsName;
    private String materialsStandard;
    private String materialsModel;
    private String materialsProducts;
    private String typeCode;
    private String materialsNumber;

    public String getMaterialsPath() {
        return materialsPath;
    }

    public void setMaterialsPath(String materialsPath) {
        this.materialsPath = materialsPath;
    }

    private String materialsPath;
    private Double materialsUnitPrice,materialsPrices;
    private Date materialsStartDate,materialsEndDate;

    public Integer getMaterialsStatus() {
        return materialsStatus;
    }

    public void setMaterialsStatus(Integer materialsStatus) {
        this.materialsStatus = materialsStatus;
    }

    public Double getMaterialsPrices() {
        return materialsPrices;
    }

    public void setMaterialsPrices(Double materialsPrices) {
        this.materialsPrices = materialsPrices;
    }

    public Integer getMaterialsDisable() {
        return materialsDisable;
    }

    public void setMaterialsDisable(Integer materialsDisable) {
        this.materialsDisable = materialsDisable;
    }

    public Integer getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }

    public Integer getIsStockAlam() {
        return isStockAlam;
    }

    public void setIsStockAlam(Integer isStockAlam) {
        this.isStockAlam = isStockAlam;
    }

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getMaterialsBarCode() {
        return materialsBarCode;
    }

    public void setMaterialsBarCode(String materialsBarCode) {
        this.materialsBarCode = materialsBarCode;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public String getMaterialsStandard() {
        return materialsStandard;
    }

    public void setMaterialsStandard(String materialsStandard) {
        this.materialsStandard = materialsStandard;
    }

    public String getMaterialsModel() {
        return materialsModel;
    }

    public void setMaterialsModel(String materialsModel) {
        this.materialsModel = materialsModel;
    }

    public String getMaterialsProducts() {
        return materialsProducts;
    }

    public void setMaterialsProducts(String materialsProducts) {
        this.materialsProducts = materialsProducts;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getMaterialsNumber() {
        return materialsNumber;
    }

    public void setMaterialsNumber(String materialsNumber) {
        this.materialsNumber = materialsNumber;
    }

    public Double getMaterialsUnitPrice() {
        return materialsUnitPrice;
    }

    public void setMaterialsUnitPrice(Double materialsUnitPrice) {
        this.materialsUnitPrice = materialsUnitPrice;
    }

    public Date getMaterialsStartDate() {
        return materialsStartDate;
    }

    public void setMaterialsStartDate(String materialsStartDate) {
        Date date=null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = df.parse(materialsStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.materialsStartDate = date;
    }

    public Date getMaterialsEndDate() {
        return materialsEndDate;
    }

    public void setMaterialsEndDate(String materialsEndDate) {
        Date date=null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = df.parse(materialsEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.materialsEndDate = date;
    }
}
