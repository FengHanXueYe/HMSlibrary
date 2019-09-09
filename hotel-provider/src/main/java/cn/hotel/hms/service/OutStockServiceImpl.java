package cn.hotel.hms.service;

import cn.hotel.entity.WZXOutStock;
import cn.hotel.hms.mapper.OutStockMapper;
import cn.hotel.service.OutStockService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 13:48
 */
@Service
public class OutStockServiceImpl implements OutStockService {
    @Autowired
    private OutStockMapper outStockMapper;

    @Override
    public Integer addOutStock(WZXOutStock wzxOutStock) {
        return outStockMapper.addOutStock(wzxOutStock);
    }
}
