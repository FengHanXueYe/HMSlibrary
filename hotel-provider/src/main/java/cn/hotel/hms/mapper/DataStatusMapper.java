package cn.hotel.hms.mapper;

import cn.hotel.entity.DataStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataStatusMapper {
    //根据指定code的查询
    List<DataStatus> queryByCode(@Param("code") String code);

}
