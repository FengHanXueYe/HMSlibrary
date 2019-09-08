package cn.hotel.service;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.Room;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.RoomVO;

public interface RoomService {
    //条件查询所有客房
    PageUtil<RoomVO> queryAll(Room room, Integer pageNum, Integer pageSize);

    //查询当前客房综合信息
    RoomVO queryByNumber(String no);
}
