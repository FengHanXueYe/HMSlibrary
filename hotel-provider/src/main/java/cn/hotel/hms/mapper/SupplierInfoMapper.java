package cn.hotel.hms.mapper;

import cn.hotel.entity.WZXSupplierInfo;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 21:41
 */
public interface SupplierInfoMapper {
    /**
     * 查询所有供应商
     * @return
     */
    List<WZXSupplierInfo> queryAllSupplierInfo();
}
