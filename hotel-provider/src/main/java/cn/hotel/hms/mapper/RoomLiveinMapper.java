package cn.hotel.hms.mapper;

import cn.hotel.entity.RoomLivein;
import cn.hotel.vo.RoomLiveinVO;
import org.apache.ibatis.annotations.Param;

public interface RoomLiveinMapper {
    //添加入住信
    Integer save(RoomLiveinVO roomLivein);

    //根据房间号查询入住客户信息
    RoomLiveinVO queryByidCode(String code);

    //换房-更新入住信息
    Integer replaceRoomNo(@Param("no") String no, @Param("repalceNo") String repalceNo);


}
