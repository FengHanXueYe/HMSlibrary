package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 兑换实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeShop implements Serializable {

    private Integer esId; // 兑换主键
    private Integer esMId; // 会员外键
    private Integer esLdId; // 商品外键
    private Integer esNum; // 兑换数量
    private Date esCreateTime; // 兑换时间

}
