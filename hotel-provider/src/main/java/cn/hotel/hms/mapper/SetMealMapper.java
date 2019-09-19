package cn.hotel.hms.mapper;

import cn.hotel.entity.SetMeal;
import cn.hotel.vo.SetMealVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SetMealMapper {
    //查询所有套餐信息
    List<SetMealVO> queryAllSetMeal(SetMeal setMeal);

    //删除套餐信息
    @Delete("DELETE FROM `setmeal` WHERE `mealid`=#{mealid}")
    Integer deleteSetMeal(Integer id);

    //修改套餐信息
    @Update("UPDATE `setmeal` SET `mealname`=#{mealname},`mealprice`=#{mealprice},`mealstatus`=#{mealstatus},`mealDetail`=#{mealDetail},mealOne=#{mealOne} where `mealid`=#{mealid}")
    Integer updateSetMeal(SetMeal setMeal);

    //增加套餐信息
    @Insert("INSERT INTO `setmeal`(`mealname`,`mealprice`,`mealstatus`,`mealDetail`,`mealOne`)VALUES(#{mealname},#{mealprice},#{mealstatus},#{mealDetail},#{mealOne})")
    Integer addSetMeal(SetMeal setMeal);

    //查看单个套餐信息
    SetMealVO detailSetMeal(Integer id);

    //查看单个套餐信息（修改时候用到）
    @Select("SELECT * FROM `setmeal` WHERE `mealid`=#{mealid}")
    SetMeal detaSetMeal(Integer id);
}
