package cn.hotel.service;

import cn.hotel.entity.RoomLivein;
import cn.hotel.vo.RoomLiveinVO;

public interface RoomLiveinService {

    //添加入住信息
    Integer save(RoomLiveinVO roomLivein);

    //根据房间号查询入住客户信息
    RoomLiveinVO queryByidCode(String code);

    //换房-更新入住信息
    Integer replaceRoomNo(String no, String repalceNo);
}