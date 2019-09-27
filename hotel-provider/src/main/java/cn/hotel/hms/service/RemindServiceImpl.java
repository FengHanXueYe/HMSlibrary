package cn.hotel.hms.service;

import cn.hotel.entity.Remind;
import cn.hotel.hms.mapper.RemindMapper;
import cn.hotel.service.RemindService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-26 14:51
 */
@Service
public class RemindServiceImpl implements RemindService {

    @Autowired
    private RemindMapper remindMapper;
    @Override
    public Integer addRemind(Remind remind) {
        return remindMapper.addRemind(remind);
    }

    @Override
    public Integer updateRemind(Remind remind) {
        return remindMapper.updateRemind(remind);
    }

    @Override
    public Integer delRemind(Integer pk) {
        return remindMapper.delRemind(pk);
    }

    @Override
    public List<Remind> queryRemindAll(Remind remind) {
        return remindMapper.queryRemindAll(remind);
    }

    @Override
    public Remind queryRemindByReId(Integer reId) {
        return remindMapper.queryRemindByReId(reId);
    }
}
