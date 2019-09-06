package cn.hotel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:入库实体类
 * @author: 汪志雄
 * @date: 2019-09-03 16:11
 */
public class WZXInstock implements Serializable {
    private Integer isId,materialsCount,materialsId;
    private String stockNumber,isPerson,remark,isNumber,isMoneyCapitalization;
    private Date isTime;
    private Double isMoney;

    public String getIsMoneyCapitalization() {
        return isMoneyCapitalization;
    }

    public void setIsMoneyCapitalization(String isMoneyCapitalization) {
        this.isMoneyCapitalization = isMoneyCapitalization;
    }

    public Double getIsMoney() {
        return isMoney;
    }

    public void setIsMoney(Double isMoney) {
        this.isMoney = isMoney;
    }

    public Integer getIsId() {
        return isId;
    }

    public void setIsId(Integer isId) {
        this.isId = isId;
    }

    public Integer getMaterialsCount() {
        return materialsCount;
    }

    public void setMaterialsCount(Integer materialsCount) {
        this.materialsCount = materialsCount;
    }

    public Integer getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(String isPerson) {
        this.isPerson = isPerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsNumber() {
        return isNumber;
    }

    public void setIsNumber(String isNumber) {
        this.isNumber = isNumber;
    }

    public Date getIsTime() {
        return isTime;
    }

    public void setIsTime(Date isTime) {
        this.isTime = isTime;
    }
}
