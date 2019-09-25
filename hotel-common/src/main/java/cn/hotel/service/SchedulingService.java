package cn.hotel.service;

import cn.hotel.entity.Scheduling;
import cn.hotel.vo.SchedulingVO;

import java.util.List;

public interface SchedulingService {

    // 查询排班人员
    List<SchedulingVO> queryAllScheduling();

    // 重置排班人员表
    Integer truncateTableScheduling();

    // 单点查询
    SchedulingVO detailScheduling(Integer sId);

    // 编辑状态
    Integer updateScheduling(Scheduling scheduling);

    // 增加
    Integer insertScheduling(Scheduling scheduling);



}
