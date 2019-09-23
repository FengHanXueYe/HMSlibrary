package cn.hotel.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodsController {

    //去食品主页面
    @RequestMapping(value = "toFoods")
    public String toFoods(){
        return "foods/index";
    }

    //去品牌故事页面
    @RequestMapping(value = "topinpai")
    public String topinpai(){
        return "foods/pinpai";
    }

    //去美食系列页面
    @RequestMapping(value = "tomeishi")
    public String tomeishi(){
        return "foods/meishi";
    }

    //去店面展示页面
    @RequestMapping(value = "toshop")
    public String toshop(){
        return "foods/shop";
    }

    //去新闻资讯页面
    @RequestMapping(value = "tonews")
    public String tonews(){
        return "foods/news";
    }

    //去关于我们页面
    @RequestMapping(value = "toaboutus")
    public String toaboutus(){
        return "foods/about-us";
    }

    //去美食工具页面
    @RequestMapping(value = "tomeishicon")
    public String tomeishicon(){

        return "foods/meishi-con";
    }

    //去新闻工具页面
    @RequestMapping(value = "tonewscon")
    public String tonewscon(){
        return "foods/news-con";
    }

    //去店铺工具页面
    @RequestMapping(value = "toshopcon")
    public String toshopcon(){
        return "foods/shop-con";
    }




}
