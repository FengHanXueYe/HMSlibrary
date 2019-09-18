package cn.hotel.hms.mapper;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.Room;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.RoomLiveinVO;
import cn.hotel.vo.RoomVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    //条件查询所有客房
    List<RoomVO> queryAll(Room room);

    //查询当前客房综合信息
    RoomVO queryByNumber(String no);

    //入住客房
    Integer save(RoomLiveinVO roomLiveinVO);

    //修改客房状态
    Integer updateStatus(Room room);

    //查询所有房间号
    List<Room> queryRoomAllNumber();
}
