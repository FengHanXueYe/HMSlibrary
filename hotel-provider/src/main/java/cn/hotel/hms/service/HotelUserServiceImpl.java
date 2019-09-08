package cn.hotel.hms.service;

import cn.hotel.entity.HotelUser;
import cn.hotel.hms.mapper.HotelUserMapper;
import cn.hotel.service.HotelUserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class HotelUserServiceImpl implements HotelUserService {

    @Autowired
    private HotelUserMapper hotelUserMapper;

    @Override
    public List<HotelUser> queryAllHotelUser() {
        return hotelUserMapper.queryAllHotelUser();
    }

    @Override
    public HotelUser detailHotelUser(HotelUser hotelUser) {
        return hotelUserMapper.detailHotelUser(hotelUser);
    }
}
