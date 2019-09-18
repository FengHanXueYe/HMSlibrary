package cn.hotel.hms.mapper;

import cn.hotel.entity.IindividualTravelers;
import cn.hotel.vo.IindividualTravelersVO;

import java.util.List;

public interface IindividualTravelersMapper {

    // 查询全部的散客
    List<IindividualTravelersVO> queryAllIindividualTravelers(IindividualTravelers  iindividualTravelers);

    // 单个查询
    IindividualTravelersVO detailIindividualTravelers(IindividualTravelers IindividualTravelers);

    // 增加
    Integer insertIindividualTravelers(IindividualTravelers iindividualTravelers);

    // 编辑
    Integer updateIindividualTravelers(IindividualTravelers iindividualTravelers);

    // 删除
    Integer deleteIindividualTravelers(Integer id);



}
