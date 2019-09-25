package cn.hotel.vo;

import java.io.Serializable;

public class RoomItemsVO implements Serializable {
    private Integer id;
    private String goodsName;
    private Integer goodsNumber;
    private double goodsPrice;
    private Integer goodsStatus;
    private String goodsStatusName; //物品状态名称
    private String roomCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsStatusName() {
        return goodsStatusName;
    }

    public void setGoodsStatusName(String goodsStatusName) {
        this.goodsStatusName = goodsStatusName;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }
}
