package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员信息实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

    private Integer mId; // 会员信息主键
    private String mNumber; // 会员编号
    private String mName; // 会员姓名
    private String mGender; // 会员性别
    private Integer mSFZtype; // 身份证号
    private String mSFZ; // 身份证
    private String mAddress; // 住址
    private String mTel; // 电话
    private Date mCreateTime; // 创建时间
    private double mTotalConsumption; // 消费金额
    private Integer mMembershipRank; //会员等级
    private String mRemarks; // 备注

}
