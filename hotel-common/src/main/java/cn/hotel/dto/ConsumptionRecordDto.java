package cn.hotel.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-26 15:57
 */
public class ConsumptionRecordDto implements Serializable {
    private Integer id;
    private Integer conType;
    private String roomNumber;
    private String conScene;
    private String conContent;
    private double conPrice;
    private String conName;
    private Date conTime;
    private String conRemarks;
    private Integer billConfirmer;
    private Integer billstatus;
    private String conBillNumber;
    private Date toConTime;
    private Date doConTime;

    public Date getToConTime() {
        return toConTime;
    }

    public void setToConTime(Date toConTime) {
        this.toConTime = toConTime;
    }

    public Date getDoConTime() {
        return doConTime;
    }

    public void setDoConTime(Date doConTime) {
        this.doConTime = doConTime;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getConBillNumber() {
        return conBillNumber;
    }

    public void setConBillNumber(String conBillNumber) {
        this.conBillNumber = conBillNumber;
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

    public Integer getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Integer billstatus) {
        this.billstatus = billstatus;
    }
}
