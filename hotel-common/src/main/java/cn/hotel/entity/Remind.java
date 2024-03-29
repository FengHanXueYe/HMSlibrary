package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-26 14:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remind implements Serializable {
    private Integer reId,rdSeeIs,rdPosition,rdConType;
    private String rdRoomNumber,rdText;
    private Date rdConTime;

    public Date getRdConTime() {
        return rdConTime;
    }

    public void setRdConTime(Date rdConTime) {
        this.rdConTime = rdConTime;
    }
}
