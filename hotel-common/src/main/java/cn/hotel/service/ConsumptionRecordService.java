package cn.hotel.service;

import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ConsumptionRecordVO;

public interface ConsumptionRecordService {

    //添加新的消费记录
    Integer save(ConsumptionRecord consumptionRecord);

    //客房账单条件分页查询
    PageUtil<ConsumptionRecordVO> queryAll(ConsumptionRecord consumptionRecord,Integer pageNo,Integer pageSize);
}
