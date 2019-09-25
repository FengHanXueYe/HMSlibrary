package cn.hotel.hms.mapper;

import cn.hotel.entity.RoomItems;
import cn.hotel.vo.RoomItemsVO;

import java.util.List;

public interface RoomItemsMapper {
    //根据房间号查询房间所有物品
    List<RoomItemsVO> queryAllByNumber(String code);
    
}
