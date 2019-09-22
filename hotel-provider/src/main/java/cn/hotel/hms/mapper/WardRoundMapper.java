package cn.hotel.hms.mapper;

import cn.hotel.entity.WardRound;
import cn.hotel.vo.WardRoundVO;

import java.util.List;

public interface WardRoundMapper {

    // 分页查询中使用的list方法
    List<WardRoundVO> queryAllWardRoundVO(WardRound wardRound);

    // 单点查询
    WardRoundVO detailWardRoundVO(Integer wrId);

    // 增加查房信息
    Integer insertWardRoundVO(WardRound wardRound);

    // 编辑查房信息
    Integer updateWardRound(WardRound wardRound);

    // 删除查房信息
    Integer deleteWardRound(Integer wrId);


}
