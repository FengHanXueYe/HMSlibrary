package cn.hotel.vo;

import java.io.Serializable;
import java.util.Date;

public class ConsumptionRecordVO implements Serializable {
    private Integer id;
    private Integer conType;
    private String conTypeName; //消费场景类型名称
    private String conScene;
    private String conContent;
    private double conPrice;
    private String conName;
    private Date conTime;
    private String conRemarks;
    private Integer billConfirmer;
    private String billConfirmerName; //账单操作人名称
    private Integer billstatus;
    private String billstatusName; //账单状态名称
    private String conBillNumber;

    @Override
    public String toString() {
        return "ConsumptionRecordVO{" +
                "id=" + id +
                ", conType=" + conType +
                ", conTypeName='" + conTypeName + '\'' +
                ", conScene='" + conScene + '\'' +
                ", conContent='" + conContent + '\'' +
                ", conPrice=" + conPrice +
                ", conName='" + conName + '\'' +
                ", conTime=" + conTime +
                ", conRemarks='" + conRemarks + '\'' +
                ", billConfirmer=" + billConfirmer +
                ", billConfirmerName='" + billConfirmerName + '\'' +
                ", billstatus=" + billstatus +
                ", billstatusName='" + billstatusName + '\'' +
                ", conBillNumber='" + conBillNumber + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConType() {
        return conType;
    }

    public void setConType(Integer conType) {
        this.conType = conType;
    }

    public String getConTypeName() {
        return conTypeName;
    }

    public void setConTypeName(String conTypeName) {
        this.conTypeName = conTypeName;
    }

    public String getConScene() {
        return conScene;
    }

    public void setConScene(String conScene) {
        this.conScene = conScene;
    }

    public String getConContent() {
        return conContent;
    }

    public void setConContent(String conContent) {
        this.conContent = conContent;
    }

    public double getConPrice() {
        return conPrice;
    }

    public void setConPrice(double conPrice) {
        this.conPrice = conPrice;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public Date getConTime() {
        return conTime;
    }

    public void setConTime(Date conTime) {
        this.conTime = conTime;
    }

    public String getConRemarks() {
        return conRemarks;
    }

    public void setConRemarks(String conRemarks) {
        this.conRemarks = conRemarks;
    }

    public Integer getBillConfirmer() {
        return billConfirmer;
    }

    public void setBillConfirmer(Integer billConfirmer) {
        this.billConfirmer = billConfirmer;
    }

    public String getBillConfirmerName() {
        return billConfirmerName;
    }

    public void setBillConfirmerName(String billConfirmerName) {
        this.billConfirmerName = billConfirmerName;
    }

    public Integer getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Integer billstatus) {
        this.billstatus = billstatus;
    }

    public String getBillstatusName() {
        return billstatusName;
    }

    public void setBillstatusName(String billstatusName) {
        this.billstatusName = billstatusName;
    }

    public String getConBillNumber() {
        return conBillNumber;
    }

    public void setConBillNumber(String conBillNumber) {
        this.conBillNumber = conBillNumber;
    }
}
