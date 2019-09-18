package cn.hotel.hms.service;

import cn.hotel.entity.RoomLivein;
import cn.hotel.hms.mapper.RoomLiveinMapper;
import cn.hotel.service.RoomLiveinService;
import cn.hotel.vo.RoomLiveinVO;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoomLiveinServiceImpl implements RoomLiveinService {

    @Autowired
    private RoomLiveinMapper roomLiveinMapper;


    @Override
    public Integer save(RoomLiveinVO roomLivein) {
        return roomLiveinMapper.save(roomLivein);
    }

    @Override
    public RoomLiveinVO queryByidCode(String code) {
        return roomLiveinMapper.queryByidCode(code);
    }
}
