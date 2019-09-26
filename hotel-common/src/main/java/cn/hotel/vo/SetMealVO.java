package cn.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetMealVO implements Serializable {
    private Integer mealid; //套餐的id
    private String mealname; //套餐的名字
    private double mealprice; //套餐价格
    private String mealstatus; //套餐状态
    private String mealDetail;//套餐详情
    private String mealOne;//套餐图片
    private Integer mealProduction;//制作时间
}
