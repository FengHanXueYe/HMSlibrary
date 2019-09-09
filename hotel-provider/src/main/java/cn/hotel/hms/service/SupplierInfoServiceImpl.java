package cn.hotel.hms.service;

import cn.hotel.entity.WZXSupplierInfo;
import cn.hotel.hms.mapper.SupplierInfoMapper;
import cn.hotel.service.SupplierInfoService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 21:43
 */
@Service
public class SupplierInfoServiceImpl implements SupplierInfoService {

    @Autowired
    private SupplierInfoMapper supplierInfoMapper;

    @Override
    public List<WZXSupplierInfo> queryAllSupplierInfo() {
        return supplierInfoMapper.queryAllSupplierInfo();
    }
}
