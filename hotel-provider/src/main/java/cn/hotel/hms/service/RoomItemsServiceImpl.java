package cn.hotel.hms.service;

import cn.hotel.entity.RoomItems;
import cn.hotel.hms.mapper.RoomItemsMapper;
import cn.hotel.service.RoomItemsService;
import cn.hotel.vo.RoomItemsVO;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoomItemsServiceImpl implements RoomItemsService {

    @Autowired
    private RoomItemsMapper roomItemsMapper;

    @Override
    public List<RoomItemsVO> queryAllByNumber(String code) {
        return roomItemsMapper.queryAllByNumber(code);
    }
}
