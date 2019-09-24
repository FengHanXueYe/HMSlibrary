package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scheduling implements Serializable {

    private Integer sId; // 排班表主键
    private Integer sOId; // 排版人员外键
    private Integer sStatus; // 值班状态

}
