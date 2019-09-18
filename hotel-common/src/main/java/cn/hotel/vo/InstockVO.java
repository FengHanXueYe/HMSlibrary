package cn.hotel.vo;

import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXStockInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 16:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstockVO implements Serializable {
    private Integer isId,materialsCount;
    private String isPerson,remark,isNumber,isMoneyCapitalization;
    private Date isTime;
    private Double isMoney;

    private WZXMaterialsInfo wzxMaterialsInfo;
    private WZXStockInfo wzxStockInfo;


    public Date getIsTime() {
        return isTime;
    }

    public void setIsTime(String isTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:sss");
        Date date;
        try {
            date = sdf.parse(isTime);
        } catch (Exception e) {
            date = null;
        }
        this.isTime = date;
    }
}
