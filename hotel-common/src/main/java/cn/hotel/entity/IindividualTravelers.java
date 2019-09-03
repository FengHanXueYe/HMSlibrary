package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 散客信息实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IindividualTravelers implements Serializable {

    private Integer itIdl; // 散客信息表主键
    private String itName; // 散客姓名
    private String itGender; // 散客性别
    private String itSFZ; // 身份证
    private String itAddress; // 散客住址
    private String itTel; // 电话
    private Date itCreateTime; // 入住时间
    private double itTotalConsumption; // 消费总额
    private String itRemarks; // 散客备注

}
