package cn.hotel.entity;

import java.io.Serializable;

public class SetMeal implements Serializable {
    private Integer mealid; //套餐的id
    private String mealname; //套餐的名字
    private double mealprice; //套餐价格
    private Integer mealstatus; //套餐状态（1.充足，2.缺少 3.暂无）
    private String mealDetail;//套餐详情

    public Integer getMealid() {
        return mealid;
    }

    public void setMealid(Integer mealid) {
        this.mealid = mealid;
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public double getMealprice() {
        return mealprice;
    }

    public void setMealprice(double mealprice) {
        this.mealprice = mealprice;
    }

    public Integer getMealstatus() {
        return mealstatus;
    }

    public void setMealstatus(Integer mealstatus) {
        this.mealstatus = mealstatus;
    }

    public String getMealDetail() {
        return mealDetail;
    }

    public void setMealDetail(String mealDetail) {
        this.mealDetail = mealDetail;
    }
}
