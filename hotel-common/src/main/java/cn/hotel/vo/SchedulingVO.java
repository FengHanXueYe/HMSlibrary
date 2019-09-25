package cn.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingVO implements Serializable {

    private Integer sId; // 排班表主键
    private Integer sOId; // 排版人员外键
    private Integer sStatus; // 值班状态
    private String sOName; // 值班人员姓名

}
