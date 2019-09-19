package cn.hotel.hms.service;

import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.hms.mapper.ConsumptionRecordMapper;
import cn.hotel.service.ConsumptionRecordService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ConsumptionRecordVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ConsumptionRecordServiceImpl implements ConsumptionRecordService {

    @Autowired
    private ConsumptionRecordMapper consumptionRecordMapper;

    @Override
    public Integer save(ConsumptionRecord consumptionRecord) {
        return consumptionRecordMapper.save(consumptionRecord);
    }

    @Override
    public PageUtil<ConsumptionRecordVO> queryAll(ConsumptionRecord consumptionRecord, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ConsumptionRecordVO> list = consumptionRecordMapper.queryAll(consumptionRecord);
        PageInfo<ConsumptionRecordVO> pageInfo=new PageInfo<>(list);
        PageUtil<ConsumptionRecordVO> pageUtil=new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageUtil.setList(pageInfo.getList());
        return pageUtil;
    }

    @Override
    public Integer repaceRoomNo(String no, String replaceNo) {
        return consumptionRecordMapper.repaceRoomNo(no,replaceNo);
    }

}
