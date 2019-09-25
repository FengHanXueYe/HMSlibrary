package cn.hotel.hms.controller;

import cn.hotel.entity.HotelUser;
import cn.hotel.service.HotelUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "hotel")
public class HotelUserController {

    @Reference
    private HotelUserService hotelUserService;

    /**
     * ajax查询全部的酒店
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllHotelUser", produces = {"application/json;charset=utf-8"}, method = RequestMethod.POST)
    public String ajaxQueryAllHotelUser(){
        List<HotelUser> hotelUsers = hotelUserService.queryAllHotelUser();
        return JSON.toJSONString(hotelUsers);
    }





}
