package cn.hotel.entity;

import java.io.Serializable;
import java.util.Date;

public class RoomLivein implements Serializable {
    private Integer id;
    private String rINo;
    private String roomNo;
    private Integer roomTypeId;
    private Integer ctype;
    private String cName;
    private Integer cSex;
    private Integer documentType;
    private String documentNo;
    private String rIaddress;
    private Integer rINumber;
    private Date checkInTime;
    private Integer preDays;
    private double rIDeposit;
    private String rIBillId;
    private String rIRemarks;
    private Integer rIOperator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrINo() {
        return rINo;
    }

    public void setrINo(String rINo) {
        this.rINo = rINo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcSex() {
        return cSex;
    }

    public void setcSex(Integer cSex) {
        this.cSex = cSex;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getrIaddress() {
        return rIaddress;
    }

    public void setrIaddress(String rIaddress) {
        this.rIaddress = rIaddress;
    }

    public Integer getrINumber() {
        return rINumber;
    }

    public void setrINumber(Integer rINumber) {
        this.rINumber = rINumber;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Integer getPreDays() {
        return preDays;
    }

    public void setPreDays(Integer preDays) {
        this.preDays = preDays;
    }

    public double getrIDeposit() {
        return rIDeposit;
    }

    public void setrIDeposit(double rIDeposit) {
        this.rIDeposit = rIDeposit;
    }

    public String getrIBillId() {
        return rIBillId;
    }

    public void setrIBillId(String rIBillId) {
        this.rIBillId = rIBillId;
    }

    public String getrIRemarks() {
        return rIRemarks;
    }

    public void setrIRemarks(String rIRemarks) {
        this.rIRemarks = rIRemarks;
    }

    public Integer getrIOperator() {
        return rIOperator;
    }

    public void setrIOperator(Integer rIOperator) {
        this.rIOperator = rIOperator;
    }
}
