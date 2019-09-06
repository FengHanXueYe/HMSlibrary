package cn.hotel.hms.mapper;

import cn.hotel.entity.Room;
import cn.hotel.utils.PageUtil;

import java.util.List;

public interface RoomMapper {
    //条件查询所有客房
    List<Room> queryAll(Room room);
}
