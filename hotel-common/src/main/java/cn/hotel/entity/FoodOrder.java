package cn.hotel.entity;

import java.io.Serializable;
import java.util.Date;

public class FoodOrder implements Serializable {
    private Integer orderid;  //订单的id号
    private double orderprice; //支付金额
    private Integer orderstatus; //(订单状态)1.已发起  2.前台取消订单 3.取消订单  4.完成
    private Date ordertime;  //订单创建时间
    private String remarks; //备注
    private String orderRoom;//订单房间号（外键）
    private String userName;//用户姓名
    private String userPhone;//用户电话

    public String getOrderRoom() {
        return orderRoom;
    }

    public void setOrderRoom(String orderRoom) {
        this.orderRoom = orderRoom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
