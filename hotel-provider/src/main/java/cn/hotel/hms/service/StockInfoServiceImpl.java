package cn.hotel.hms.service;

import cn.hotel.entity.WZXStockInfo;
import cn.hotel.hms.mapper.StockInfoMapper;
import cn.hotel.service.StockInfoService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 21:43
 */
@Service
public class StockInfoServiceImpl implements StockInfoService {

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Override
    public List<WZXStockInfo> queryAllStockInfo() {
        return stockInfoMapper.queryAllStockInfo();
    }
}
