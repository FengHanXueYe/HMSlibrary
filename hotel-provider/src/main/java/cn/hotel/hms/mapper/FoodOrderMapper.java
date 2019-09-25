package cn.hotel.hms.mapper;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.entity.FoodOrder;
import cn.hotel.entity.Room;
import cn.hotel.entity.SetMeal;
import cn.hotel.vo.FoodOrderVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FoodOrderMapper {
    //查询所有订单信息
    List<FoodOrderVo> queryAllFoodOrder(FoodOrder foodOrder);

    //增加订单信息
    @Insert("INSERT INTO `foodorder`(`foodsid`,`shopnumber`,`setmealid`,`orderRoom`,`userName`,`userPhone`,`remarks`,`orderstatus`,`ordertime`,`orderprice`) VALUES(#{foodsid},#{shopnumber},#{setmealid},#{orderRoom},#{userName},#{userPhone},#{remarks},1,now(),#{orderprice})")
    Integer addFoodOrder(FoodOrder foodOrder);

    //修改订单信息
    @Update("UPDATE `foodorder` SET foodsid=#{foodsid},shopnumber=#{shopnumber},setmealid=#{setmealid},orderRoom=#{orderRoom},userName=#{userName},userPhone=#{userPhone},orderprice=#{orderprice} where orderid=#{orderid}")
    Integer updateFoodOrder(FoodOrder foodOrder);

    //查看单个订单信息
    FoodOrderVo detailFoodOrder(Integer id);

    //删除订单信息
    @Delete("DELETE FROM `foodorder` WHERE orderid=#{orderid}")
    Integer deleteFoodOrder(Integer id);

    //查询全部食品（增加时候用到）
    @Select("SELECT * FROM `deliciousfood`")
    List<DeliciousFood> queryAllDeliciousFood();

    //查询全部套餐（增加时候用到）
    @Select("SELECT * FROM `setmeal`")
    List<SetMeal> queryAllSetMeal();

    //查询全部房间（查询时候用到）
    @Select("SELECT * FROM `room`")
    List<Room> queryAllRoom();

    //查看单个订单信息（修改回显时候用到）
    @Select("SELECT * FROM `foodorder` WHERE orderid=#{orderid}")
    FoodOrder detailFoodOrders(Integer id);
}
