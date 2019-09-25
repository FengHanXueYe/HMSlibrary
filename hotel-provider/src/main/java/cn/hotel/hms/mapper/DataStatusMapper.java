package cn.hotel.hms.mapper;

import cn.hotel.entity.DataStatus;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.DataStatusVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataStatusMapper {

    //根据条件查询状态
    List<DataStatusVO> queryAll(DataStatus status);

    //根据指定code的查询
    List<DataStatus> queryByCode(@Param("code") String code);

    //添加新的类型
    Integer save(DataStatus status);

    //修改类型信息
    Integer update(DataStatus status);

    //根据id查询类型信息
    DataStatusVO queryById(Integer id);

    //删除类型信息
    Integer delById(Integer id);

}
