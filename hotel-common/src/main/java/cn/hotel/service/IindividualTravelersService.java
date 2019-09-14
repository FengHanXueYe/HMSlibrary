package cn.hotel.service;

import cn.hotel.entity.IindividualTravelers;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.IindividualTravelersVO;

public interface IindividualTravelersService {

    // 查询选全部散客列表分页
    PageUtil<IindividualTravelersVO> queryAllIindividualTravelersPage(IindividualTravelers iindividualTravelers, Integer pageNum, Integer pageSize);

    // 单个查询
    IindividualTravelersVO detailIindividualTravelers(IindividualTravelers IindividualTravelers);

    // 增加
    Integer insertIindividualTravelers(IindividualTravelers iindividualTravelers);

    // 编辑
    Integer updateIindividualTravelers(IindividualTravelers iindividualTravelers);

    // 删除
    Integer deleteIindividualTravelers(Integer id);








}
