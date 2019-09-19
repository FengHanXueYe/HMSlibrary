package cn.hotel.hms.service;

import cn.hotel.entity.Luck;
import cn.hotel.hms.mapper.LuckMapper;
import cn.hotel.service.LuckService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LuckServiceImpl implements LuckService {

    @Autowired
    private LuckMapper luckMapper;

    @Override
    public Integer insertLuck(Luck luck) {
        return luckMapper.insertLuck(luck);
    }
}
