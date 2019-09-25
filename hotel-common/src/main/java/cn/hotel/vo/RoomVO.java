package cn.hotel.vo;

import java.io.Serializable;

public class RoomVO implements Serializable {
    private Integer id;
    private String roomNumber;
    private Integer roomType;
    private String roomTypeName; //客房类型名称
    private Integer roomStatus;
    private String roomStatusName; // 客房状态名称
    private String roomStatusRisorse; //客房状态展示图片
    private double roomPrice;
    private Integer roomBed;
    private double roomDeposit;


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

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomStatusName() {
        return roomStatusName;
    }

    public void setRoomStatusName(String roomStatusName) {
        this.roomStatusName = roomStatusName;
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
