package cn.hotel.service;

import cn.hotel.entity.Room;
import cn.hotel.utils.PageUtil;

public interface RoomService {
    //条件查询所有客房
    PageUtil<Room> queryAll(Room room,Integer pageNum,Integer pageSize);
}
