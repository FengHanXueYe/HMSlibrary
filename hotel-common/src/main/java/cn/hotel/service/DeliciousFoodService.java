package cn.hotel.service;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.utils.PageInfoUtil;
import cn.hotel.vo.DeliciousFoodVo;

public interface DeliciousFoodService {
    //查询所有食品信息
    PageInfoUtil<DeliciousFoodVo> queryAllFood(DeliciousFood deliciousFood, Integer pageNum, Integer pageSize);

    //增加食品信息
    Integer addDeliciousFood(DeliciousFood deliciousFood);

    //删除食品信息
    Integer deleteDeliciousFood(Integer id);

    //查看单个食品信息
    DeliciousFoodVo detailDeliciousFood(Integer id);

    //修改食品信息
    Integer updateDeliciousFood(DeliciousFood deliciousFood);
}
