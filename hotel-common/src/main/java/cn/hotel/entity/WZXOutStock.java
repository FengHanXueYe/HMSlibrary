package cn.hotel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:出库单实体类
 * @author: 汪志雄
 * @date: 2019-09-03 16:23
 */
public class WZXOutStock implements Serializable {
    private Integer osId,materialsId,materialsCount;
    private String outStockNumber,osNumber,receivePerson,osRemark;
    private Date osTime;

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public Integer getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }

    public Integer getMaterialsCount() {
        return materialsCount;
    }

    public void setMaterialsCount(Integer materialsCount) {
        this.materialsCount = materialsCount;
    }

    public String getOutStockNumber() {
        return outStockNumber;
    }

    public void setOutStockNumber(String outStockNumber) {
        this.outStockNumber = outStockNumber;
    }

    public String getOsNumber() {
        return osNumber;
    }

    public void setOsNumber(String osNumber) {
        this.osNumber = osNumber;
    }

    public String getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson;
    }

    public String getOsRemark() {
        return osRemark;
    }

    public void setOsRemark(String osRemark) {
        this.osRemark = osRemark;
    }

    public Date getOsTime() {
        return osTime;
    }

    public void setOsTime(Date osTime) {
        this.osTime = osTime;
    }
}
