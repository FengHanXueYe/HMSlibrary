package cn.hotel.vo;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXMaterialsLocation;
import cn.hotel.entity.WZXStockInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @description:实际库存模型
 * @author: 汪志雄
 * @date: 2019-09-06 10:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualsStockVO implements Serializable {
    private Integer asNumber,materialss;
   private WZXMaterialsInfo materialsInfo;
   private WZXStockInfo stockInfo;
   private WZXMaterialsLocation materialsLocation;
   private List<DataStatus> statusList;
}
