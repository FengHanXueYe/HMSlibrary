package cn.hotel.service;

import cn.hotel.entity.ToDayWardRound;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ToDayWardRoundVO;

import java.util.List;

public interface ToDayWardRoundService {

    // 查询全部的今天的房间
    PageUtil<ToDayWardRoundVO> queryAllToDayWardRoundPage(ToDayWardRound toDayWardRound, Integer pageNum, Integer pageSize);

    // 增加房间
    Integer insertToDayWardRound(ToDayWardRound toDayWardRound);

    // 编辑
    Integer updateToDayWardRound(ToDayWardRound toDayWardRound);

    // 删除
    Integer deleteToDayWardRound(Integer tdwrId);

    // 单点查询
    ToDayWardRoundVO detailTDWRV(Integer tdwrId);

    // 清空昨天查房表中的数据
    Integer truncateTable();







}
