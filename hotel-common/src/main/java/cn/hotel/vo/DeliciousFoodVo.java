package cn.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliciousFoodVo implements Serializable {
    private Integer foodid;  //美食的id
    private String foodname; //美食的名字
    private String foodimgone; //美食的图片 1
    private String foodtypes;  //美食类型
    private double foodprice; //价格
    private String foodstat;//菜品状态
    private String foodDetail;//菜品详情
    private Integer foodProduction;//制作时间
}
