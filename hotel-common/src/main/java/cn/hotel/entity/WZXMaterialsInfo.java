package cn.hotel.entity;

import java.io.Serializable;
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
    private Integer materialsId,isStockAlam,supplierNumber,materialsDisable;
    private String materialsBarCode,materialsName,materialsStandard,materialsModel,materialsProducts,typeCode,materialsNumber;
    private Double materialsUnitPrice,materialsPrices;
    private Date materialsStartDate,materialsEndDate;

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

    public void setMaterialsStartDate(Date materialsStartDate) {
        this.materialsStartDate = materialsStartDate;
    }

    public Date getMaterialsEndDate() {
        return materialsEndDate;
    }

    public void setMaterialsEndDate(Date materialsEndDate) {
        this.materialsEndDate = materialsEndDate;
    }
}
