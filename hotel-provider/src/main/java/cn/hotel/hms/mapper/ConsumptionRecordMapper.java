package cn.hotel.hms.mapper;

import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ConsumptionRecordVO;

import java.util.List;

public interface ConsumptionRecordMapper {
    //添加新的消费记录
    Integer save(ConsumptionRecord consumptionRecord);

    //客房账单条件分页查询
    List<ConsumptionRecordVO> queryAll(ConsumptionRecord consumptionRecord);
}
