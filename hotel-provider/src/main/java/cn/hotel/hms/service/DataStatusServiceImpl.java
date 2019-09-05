package cn.hotel.hms.service;

import cn.hotel.entity.DataStatus;
import cn.hotel.hms.mapper.DataStatusMapper;
import cn.hotel.service.DataStatusService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DataStatusServiceImpl implements DataStatusService {

    @Autowired
    private DataStatusMapper dataStatusMapper;
    @Override
    public List<DataStatus> queryByCode(String code) {
        return dataStatusMapper.queryByCode(code);
    }

}
