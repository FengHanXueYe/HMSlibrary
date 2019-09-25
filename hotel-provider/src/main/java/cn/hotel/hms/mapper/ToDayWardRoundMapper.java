package cn.hotel.hms.mapper;

import cn.hotel.entity.ToDayWardRound;
import cn.hotel.vo.ToDayWardRoundVO;

import java.util.List;

public interface ToDayWardRoundMapper {

    // 查询全部的今天要查的房间
    List<ToDayWardRoundVO> queryAllTDWRV(ToDayWardRound toDayWardRound);

    // 增加房间
    Integer insertToDayWardRound(ToDayWardRound toDayWardRound);

    // 编辑
    Integer updateToDayWardRound(ToDayWardRound toDayWardRound);

    // 删除
    Integer deleteToDayWardRound(Integer tdwrId);

    // 单点查询
    ToDayWardRoundVO detailTDWRV(Integer tdwrId);

    Integer truncateTable();

}
