package cn.hotel.vo;

import cn.hotel.entity.MembershipRank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements Serializable {

    private Integer mId; // 会员信息主键
    private String mNumber; // 会员编号
    private String mName; // 会员姓名
    private Integer mGender; // 会员性别
    private Integer mSFZtype; // 身份证类型
    private String mSFZtypeName; // 身份证类型名称
    private String mSFZ; // 身份证号码
    private String mAddress; // 住址
    private String mTel; // 电话
    private Date mCreateTime; // 创建时间
    private double mTotalConsumption; // 消费金额
    private MembershipRank mMembershipRank; //会员等级
    private String mMembershipRankName; //会员等级
    private String mRemarks; // 备注


}
