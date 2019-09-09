package cn.hotel.service;

import cn.hotel.entity.WZXSupplierInfo;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 21:39
 */
public interface SupplierInfoService {

    /**
     * 查询所有供应商
     * @return
     */
    List<WZXSupplierInfo> queryAllSupplierInfo();
}
