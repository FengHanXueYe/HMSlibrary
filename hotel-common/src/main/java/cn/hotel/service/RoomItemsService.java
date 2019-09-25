package cn.hotel.service;

import cn.hotel.entity.RoomItems;
import cn.hotel.vo.RoomItemsVO;

import java.util.List;

public interface RoomItemsService {

    //根据房间号查询房间所有物品
    List<RoomItemsVO> queryAllByNumber(String code);
}
