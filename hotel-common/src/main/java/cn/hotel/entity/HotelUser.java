package cn.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 酒店用户实体（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelUser implements Serializable {

    private Integer huId; // 酒店用户主键
    private String huName; // 酒店名称
    private String huAddress; // 酒店地址
    private String huGrade; // 酒店等级
    private String huTel; // 酒店电话
    private String huBL; // 营业执照号
    private String huLegalPerson; // 法人
    private String huNumber; // 酒店编号


}
