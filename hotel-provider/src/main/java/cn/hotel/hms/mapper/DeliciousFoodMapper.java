package cn.hotel.hms.mapper;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.vo.DeliciousFoodVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeliciousFoodMapper {
    //查询所有食品信息
    List<DeliciousFoodVo> queryAllFood(DeliciousFood deliciousFood);

    //增加食品信息
    @Insert("INSERT INTO `deliciousfood`(`foodname`,`foodimgone`,`foodtype`,`foodprice`,`foodstatus`,`foodDetail`)VALUES(#{foodname},#{foodimgone},#{foodtype},#{foodprice},#{foodstatus},#{foodDetail})")
    Integer addDeliciousFood(DeliciousFood deliciousFood);

    //删除食品信息
    @Delete("DELETE FROM`deliciousfood` WHERE `foodid`=#{foodid}")
    Integer deleteDeliciousFood(Integer id);

    //查看单个食品信息
    DeliciousFoodVo detailDeliciousFood(Integer id);

    //修改食品信息
    @Update("UPDATE `deliciousfood` SET `foodname`=#{foodname},`foodimgone`=#{foodimgone},`foodtype`=#{foodtype},`foodprice`=#{foodprice},`foodstatus`=#{foodstatus},`foodDetail`=#{foodDetail} where `foodid`=#{foodid}")
    Integer updateDeliciousFood(DeliciousFood deliciousFood);

    //查看食品信息（修改时候用到）
    @Select("SELECT * FROM `deliciousfood` WHERE foodid=#{foodid}")
    DeliciousFood detaDeliciousFood(Integer id);
}
