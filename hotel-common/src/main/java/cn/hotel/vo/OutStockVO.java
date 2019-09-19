package cn.hotel.vo;

import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXStockInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-11 10:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutStockVO implements Serializable {
    private Integer osId,materialsCount;
    private String osNumber,receivePerson,osRemark;
    private Date osTime,toTime,reachTime;

    private WZXMaterialsInfo wzxMaterialsInfo;
    private WZXStockInfo stockInfo;
    public Date getOsTime() {
        return osTime;
    }

    public void setOsTime(String osTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(osTime);
        } catch (Exception e) {
            date = null;
        }
        this.osTime = date;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        Date parse =null;
        try {
            parse =simpleDateFormat.parse(toTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.toTime = parse;
    }

    public Date getReachTime() {
        return reachTime;
    }

    public void setReachTime(String reachTime) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        Date parse =null;
        try {
            parse =simpleDateFormat.parse(reachTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.reachTime = parse;
    }
}
