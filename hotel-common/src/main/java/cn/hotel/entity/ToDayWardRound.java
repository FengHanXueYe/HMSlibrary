package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 今日查房表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDayWardRound implements Serializable {

    private Integer tdwrId; // 今日查房表主键
    private Integer tdwrOId; // 查房人外键
    private String tdwrRoomNumber; // 房间编号
    private String tdwrDetail; // 查房情况
    private Date tdwrCreatetime; // 查房时间
    private Integer tdwrStatus; // 查房状态

}
