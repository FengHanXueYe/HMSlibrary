package cn.hotel.vo;

import cn.hotel.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 积分实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberShipScoreVO implements Serializable {

    private Integer mssId; // 积分表主键
    private Integer mssMId; // 会员外键
    private double mssIntegral; // 会员积分
    private Integer mssStatus; // 抽奖状态
    private String mName; // 会员姓名
    private String mMSR; // 会员等级

}
