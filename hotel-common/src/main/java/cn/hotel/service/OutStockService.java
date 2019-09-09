package cn.hotel.service;

import cn.hotel.entity.WZXOutStock;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 13:31
 */
public interface OutStockService {

    /**
     * 增加出库单，减少实际库房数量UpdatedelMaterialsInfoByMaterialsId（）
     * @param wzxOutStock
     * @return
     */
    Integer addOutStock(WZXOutStock wzxOutStock);
}
