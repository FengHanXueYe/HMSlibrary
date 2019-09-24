package cn.hotel.hms.service;

import cn.hotel.entity.Scheduling;
import cn.hotel.hms.mapper.SchedulingMapper;
import cn.hotel.service.SchedulingService;
import cn.hotel.vo.SchedulingVO;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private SchedulingMapper schedulingMapper;

    @Override
    public List<SchedulingVO> queryAllScheduling() {
        return schedulingMapper.queryAllScheduling();
    }

    @Override
    public Integer truncateTableScheduling() {
        return schedulingMapper.truncateTableScheduling();
    }

    @Override
    public SchedulingVO detailScheduling(Integer sId) {
        return schedulingMapper.detailScheduling(sId);
    }

    @Override
    public Integer updateScheduling(Scheduling scheduling) {
        return schedulingMapper.updateScheduling(scheduling);
    }

    @Override
    public Integer insertScheduling(Scheduling scheduling) {
        return schedulingMapper.insertScheduling(scheduling);
    }
}
