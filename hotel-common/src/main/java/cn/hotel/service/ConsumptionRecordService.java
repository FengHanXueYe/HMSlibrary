package cn.hotel.service;

import cn.hotel.dto.ConsumptionRecordDto;
import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ConsumptionRecordVO;

public interface ConsumptionRecordService {

    //添加新的消费记录
    Integer save(ConsumptionRecord consumptionRecord);

    //客房账单条件分页查询
    PageUtil<ConsumptionRecordVO> queryAll(ConsumptionRecord consumptionRecord, Integer pageNo, Integer pageSize);

    //换房-更新消费记录信息
    Integer repaceRoomNo(String no, String replaceNo);

    //查询所有当天营业额、入住人数
    ConsumptionRecord   queryConsumptionRecordCount();

    //查询所有记录
    PageUtil<ConsumptionRecord>  queryAllByConsumptionRecore(ConsumptionRecordDto consumptionRecord, Integer pageNo, Integer pageSize);

    //根据账单编号查询指定消息
    ConsumptionRecord  queryConsumptionRecordByconBillNumber(String conBillNumber);

}
