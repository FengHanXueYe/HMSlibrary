package cn.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderVo implements Serializable {
    private Integer orderid;  //订单的id号
    private double orderprice; //支付金额
    private String orderstatus; //(订单状态)
    private Date ordertime;  //订单创建时间
    private String remarks; //备注
    private String orderRoom;//订单房间号（外键）
    private String userName;//用户姓名
    private String userPhone;//用户电话
    private Integer shopnumber;//商品数量
    private Integer foodsid;//食品id
    private Integer setmealid;//套餐id
    private Integer id;
    private String roomNumber;
    private Integer roomType;
    private Integer roomStatus;
    private double roomPrice;
    private Integer roomBed;
    private double roomDeposit;

}
