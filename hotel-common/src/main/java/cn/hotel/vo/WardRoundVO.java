package cn.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 查房记录实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardRoundVO implements Serializable {

    private Integer wrId; // 查房表主键
    private Integer wrOId; // 操作人员外键
    private String wrRoomNumber; // 房间编号
    private String wrDetail; // 查房备注
    private Date wrCreatetime; // 查房时间
    private String wrOName; // 操作人员姓名
    private String wrODepartment; // 操作人员不门表
    private Integer wrStatus; // 查房状态
    private Integer wrToDay; // 判断是今天

}
