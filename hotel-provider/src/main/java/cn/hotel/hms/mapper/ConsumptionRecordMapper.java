package cn.hotel.hms.mapper;

import cn.hotel.dto.ConsumptionRecordDto;
import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.vo.ConsumptionRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsumptionRecordMapper {
    //添加新的消费记录
    Integer save(ConsumptionRecord consumptionRecord);

    //客房账单条件分页查询
    List<ConsumptionRecordVO> queryAll(ConsumptionRecord consumptionRecord);

    //换房-更新消费记录信息
    Integer repaceRoomNo(@Param("no") String no, @Param("replaceNo") String replaceNo);

    //查询所有当天营业额、入住人数
    ConsumptionRecord   queryConsumptionRecordCount();

    //查询所有记录
    List<ConsumptionRecord> queryAllByConsumptionRecore(ConsumptionRecordDto consumptionRecord);

    //根据账单编号查询指定消息
    ConsumptionRecord  queryConsumptionRecordByconBillNumber(String conBillNumber);
}
