package cn.hotel.hms.mapper;

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
}
