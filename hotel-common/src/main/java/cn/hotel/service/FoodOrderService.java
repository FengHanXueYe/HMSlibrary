package cn.hotel.service;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.entity.FoodOrder;
import cn.hotel.entity.Room;
import cn.hotel.entity.SetMeal;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.FoodOrderVo;

import java.util.List;

public interface FoodOrderService {

    //查询所有订单信息
    PageUtil<FoodOrderVo> queryAllFoodOrder(FoodOrder foodOrder,Integer pageNum, Integer pageSize);

    //增加订单信息
    Integer addFoodOrder(FoodOrder foodOrder);

    //修改订单信息
    Integer updateFoodOrder(FoodOrder foodOrder);

    //查看单个订单信息
    FoodOrderVo detailFoodOrder(Integer id);

    //删除订单信息
    Integer deleteFoodOrder(Integer id);

    //查询全部食品（增加时候用到）
    List<DeliciousFood> queryAllDeliciousFood();

    //查询全部套餐（增加时候用到）
    List<SetMeal> queryAllSetMeal();

    //查询全部房间（查询时候用到）
    List<Room> queryAllRoom();

    //查看单个订单信息（修改回显时候用到）
    FoodOrder detailFoodOrders(Integer id);
}
