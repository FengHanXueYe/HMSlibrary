package cn.hotel.vo;

import java.io.Serializable;

public class RoomVO implements Serializable {
    private Integer id;
    private String roomNumber;
    private String roomNumberValue; //状态展示图片
    private Integer roomType;
    private String roomTypeName; //客房类型名称
    private Integer roomStatus;
    private String roomStatusRisorse; //状态展示图片
    private double roomPrice;
    private Integer roomBed;
    private double roomDeposit;


    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getRoomNumberValue() {
        return roomNumberValue;
    }

    public void setRoomNumberValue(String roomNumberValue) {
        this.roomNumberValue = roomNumberValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomStatusRisorse() {
        return roomStatusRisorse;
    }

    public void setRoomStatusRisorse(String roomStatusRisorse) {
        this.roomStatusRisorse = roomStatusRisorse;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getRoomBed() {
        return roomBed;
    }

    public void setRoomBed(Integer roomBed) {
        this.roomBed = roomBed;
    }

    public double getRoomDeposit() {
        return roomDeposit;
    }

    public void setRoomDeposit(double roomDeposit) {
        this.roomDeposit = roomDeposit;
    }
}
