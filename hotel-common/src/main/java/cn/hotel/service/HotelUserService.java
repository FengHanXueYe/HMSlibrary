package cn.hotel.service;

import cn.hotel.entity.HotelUser;

import java.util.List;

/**
 * 酒店用户service
 */
public interface HotelUserService {

    // 查询全部的酒店
    List<HotelUser> queryAllHotelUser();

    // 单个查询
    HotelUser detailHotelUser(HotelUser hotelUser);





}
