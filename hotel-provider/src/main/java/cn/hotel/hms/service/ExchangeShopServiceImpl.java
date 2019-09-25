package cn.hotel.hms.service;

import cn.hotel.entity.ExchangeShop;
import cn.hotel.hms.mapper.ExchangeShopMapper;
import cn.hotel.service.ExchangeShopService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ExchangeShopServiceImpl implements ExchangeShopService {

    @Autowired
    private ExchangeShopMapper exchangeShopMapper;

    @Override
    public Integer insertExchangeShop(ExchangeShop exchangeShop) {
        return exchangeShopMapper.insertExchangeShop(exchangeShop);
    }
}
