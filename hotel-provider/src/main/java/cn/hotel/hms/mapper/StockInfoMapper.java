package cn.hotel.hms.mapper;

import cn.hotel.entity.WZXStockInfo;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 21:40
 */
public interface StockInfoMapper {
    /**
     * 查询所有库房
     * @return
     */
    List<WZXStockInfo> queryAllStockInfo();
}
