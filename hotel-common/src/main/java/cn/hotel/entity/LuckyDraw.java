package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 物品实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LuckyDraw implements Serializable {

    private Integer ldId; // 物品表主键
    private String ldName; // 物品名称
    private String ldNumber; // 物品编号
    private double ldShopIntegral; // 物品积分价格
    private Integer ldShopNum; // 商品数量
    private Date ldCreateTime; // 创建时间

}
