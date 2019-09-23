package cn.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *  操作人员实体VO（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorVO implements Serializable {

    private Integer oId; // 操作人员表主键
    private String oName; // 操作人员姓名
    private String oDepartment; // 操作人员部门
    private String oStatus; // 操作人员权限等级
    private String oSalary; // 工资等级
    private String oWorkStatus; // 工作状态 （请假，正常工作。。。）
    private String oTel; // 电话
    private String oSFZ; // 身份证
    private String oAddress; // 住址
    private String oGender; // 性别
    private Date oCreateTime; // 入职时间
    private String oHotelUserNum; // 操作人员所属酒店编号
    private String oHotelUserNumName; // 操作人员所属酒店编号
    private String oPassword; // 操作人员登录密码
    private String oEmail; // 操作人员邮箱
    private Integer oDisabled; // 禁用
    private Integer oExpired; // 过期

}
