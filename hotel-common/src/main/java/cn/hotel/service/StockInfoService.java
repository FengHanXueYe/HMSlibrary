package cn.hotel.service;

import cn.hotel.entity.WZXStockInfo;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 21:38
 */
public interface StockInfoService {
    /**
     * 查询所有库房
     * @return
     */
    List<WZXStockInfo> queryAllStockInfo();
}
