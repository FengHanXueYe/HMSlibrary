package cn.hotel.entity;

import java.io.Serializable;

public class DeliciousFood implements Serializable {
    private Integer foodid;  //美食的id
    private String foodname; //美食的名字
    private String foodimgone; //美食的图片 1
    private Integer foodtype;  //类型状态表（Datastatus）取值
    private double foodprice; //价格
    private Integer foodstatus;//菜品状态（1.充足，2.缺少 3.暂无）
    private String foodDetail;//菜品详情
    private Integer foodProduction;//制作时间

    public Integer getFoodProduction() {
        return foodProduction;
    }

    public void setFoodProduction(Integer foodProduction) {
        this.foodProduction = foodProduction;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodimgone() {
        return foodimgone;
    }

    public void setFoodimgone(String foodimgone) {
        this.foodimgone = foodimgone;
    }

    public Integer getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(Integer foodtype) {
        this.foodtype = foodtype;
    }

    public double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(double foodprice) {
        this.foodprice = foodprice;
    }

    public Integer getFoodstatus() {
        return foodstatus;
    }

    public void setFoodstatus(Integer foodstatus) {
        this.foodstatus = foodstatus;
    }

    public String getFoodDetail() {
        return foodDetail;
    }

    public void setFoodDetail(String foodDetail) {
        this.foodDetail = foodDetail;
    }
}
