package cn.hotel.entity;

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
public class WardRound implements Serializable {

    private Integer wrId; // 查房表主键
    private Integer wrOId; // 操作人员外键
    private Integer wrRoomNumber; // 房间编号
    private String wrDetail; // 查房备注
    private Date wrCreatetime; // 查房时间

}
