package cn.hotel.entity;

import java.io.Serializable;

public class RoomNumber implements Serializable {
    private Integer id;
    private String roomNumber;
    private Integer roomType;
    private Integer roomStatus;
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

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
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
