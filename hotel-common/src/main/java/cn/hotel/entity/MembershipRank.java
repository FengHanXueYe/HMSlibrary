package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 会员等级实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipRank implements Serializable {

    private Integer mrId; // 会员等级表主键
    private String mrName; // 会员等级名称
    private String mrFavouredPolicy; // 优惠政策
    private double mrDiscountRate; // 折扣率
    private String mrDetail; //描述


}
