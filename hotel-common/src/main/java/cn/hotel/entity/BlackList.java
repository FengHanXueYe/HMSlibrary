package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 黑名单实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlackList implements Serializable {

    private Integer blId; // 黑名单主键
    private String blName; // 黑名单用户名称
    private Integer blSFZtype; // 证件类型
    private String blSFZ; // 证件号
    private String blDetail; // 原因
    private Date blCreateTime; // 创建时间（系统当前时间）

}
