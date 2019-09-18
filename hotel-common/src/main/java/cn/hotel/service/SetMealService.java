package cn.hotel.service;

import cn.hotel.entity.SetMeal;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.SetMealVO;

public interface SetMealService {
    //查询所有套餐信息
    PageUtil<SetMealVO> queryAllSetMeal(SetMeal setMeal, Integer pageNum, Integer pageSize);

    //删除套餐信息
    Integer deleteSetMeal(Integer id);

    //修改套餐信息
    Integer updateSetMeal(SetMeal setMeal);

    //增加套餐信息
    Integer addSetMeal(SetMeal setMeal);

    //查看单个套餐信息
    SetMealVO detailSetMeal(Integer id);

    //查看单个套餐信息（修改时候用到）
    SetMeal detaSetMeal(Integer id);
}
