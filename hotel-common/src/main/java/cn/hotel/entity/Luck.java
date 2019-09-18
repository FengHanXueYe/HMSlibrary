package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽奖实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Luck implements Serializable {

    private Integer lId; // 抽奖表主键
    private Integer lMId; // 会员外键
    private Integer lLdId; // 商品外键
    private Date lCreateTime; // 抽奖时间

}
