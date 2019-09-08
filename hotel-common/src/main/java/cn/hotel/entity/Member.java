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
    private Integer mGender; // 会员性别
    private Integer mSFZtype; // 身份证号
    private String mSFZ; // 身份证
    private String mAddress; // 住址
    private String mTel; // 电话
    private Date mCreateTime; // 创建时间
    private double mTotalConsumption; // 消费金额
    private Integer mMembershipRank; //会员等级
    private String mRemarks; // 备注

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getmGender() {
        return mGender;
    }

    public void setmGender(Integer mGender) {
        this.mGender = mGender;
    }

    public Integer getmSFZtype() {
        return mSFZtype;
    }

    public void setmSFZtype(Integer mSFZtype) {
        this.mSFZtype = mSFZtype;
    }

    public String getmSFZ() {
        return mSFZ;
    }

    public void setmSFZ(String mSFZ) {
        this.mSFZ = mSFZ;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmTel() {
        return mTel;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }

    public Date getmCreateTime() {
        return mCreateTime;
    }

    public void setmCreateTime(Date mCreateTime) {
        this.mCreateTime = mCreateTime;
    }

    public double getmTotalConsumption() {
        return mTotalConsumption;
    }

    public void setmTotalConsumption(double mTotalConsumption) {
        this.mTotalConsumption = mTotalConsumption;
    }

    public Integer getmMembershipRank() {
        return mMembershipRank;
    }

    public void setmMembershipRank(Integer mMembershipRank) {
        this.mMembershipRank = mMembershipRank;
    }

    public String getmRemarks() {
        return mRemarks;
    }

    public void setmRemarks(String mRemarks) {
        this.mRemarks = mRemarks;
    }
}
