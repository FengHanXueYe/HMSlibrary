package cn.hotel.hms.mapper;

import cn.hotel.entity.HotelUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HotelUserMapper {

    // 查询全部的酒店
    @Select("select * from hoteluser")
    List<HotelUser> queryAllHotelUser();

    // 单个查询
    HotelUser detailHotelUser(HotelUser hotelUser);


}
