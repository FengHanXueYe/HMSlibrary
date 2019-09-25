package cn.hotel.service;

import cn.hotel.entity.WardRound;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.WardRoundVO;

public interface WardRoundService  {

    // 查询全部的查房给信息
    PageUtil<WardRoundVO> queryAllWardRoundPage(WardRound wardRound, Integer pageNum, Integer pageSize);

    // 单点查询
    WardRoundVO detailWardRoundVO(Integer wrId);

    // 增加查房信息
    Integer insertWardRoundVO(WardRound wardRound);

    // 编辑查房信息
    Integer updateWardRound(WardRound wardRound);

    // 删除查房信息
    Integer deleteWardRound(Integer wrId);

    // 批量编辑今天查房状态
    Integer updateWR(WardRound wardRound);
}
