package cn.hotel.service;

import cn.hotel.entity.WZXMaterialsLocation;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 14:54
 */
public interface MaterialsLocationService {
    /**
     * 删除货位
     * @param goodsLocationNumber
     * @return
     */
    Integer delMaterialsLocation(Integer goodsLocationNumber);

    /**
     * 添加货位
     * @param actualsStockVO
     * @return
     */
    Integer addMaterialsLocation(WZXMaterialsLocation actualsStockVO);
}
