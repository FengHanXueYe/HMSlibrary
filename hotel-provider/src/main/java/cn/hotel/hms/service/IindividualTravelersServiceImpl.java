package cn.hotel.hms.service;

import cn.hotel.entity.IindividualTravelers;
import cn.hotel.hms.mapper.IindividualTravelersMapper;
import cn.hotel.service.IindividualTravelersService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.IindividualTravelersVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class IindividualTravelersServiceImpl implements IindividualTravelersService {

    @Autowired
    private IindividualTravelersMapper iindividualTravelersMapper;

    @Override
    public PageUtil<IindividualTravelersVO> queryAllIindividualTravelersPage(IindividualTravelers iindividualTravelers, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<IindividualTravelersVO> iindividualTravelers1 = iindividualTravelersMapper.queryAllIindividualTravelers(iindividualTravelers);
        PageInfo<IindividualTravelersVO> pageInfo = new PageInfo<>(iindividualTravelers1);
        PageUtil<IindividualTravelersVO> pageUtil = new PageUtil<>();
        pageUtil.setTotalPageCount(pageInfo.getPages());
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setList(pageInfo.getList());
        return pageUtil;
    }

    @Override
    public IindividualTravelersVO detailIindividualTravelers(IindividualTravelers IindividualTravelers) {
        return iindividualTravelersMapper.detailIindividualTravelers(IindividualTravelers);
    }

    @Override
    public Integer insertIindividualTravelers(IindividualTravelers iindividualTravelers) {
        return iindividualTravelersMapper.insertIindividualTravelers(iindividualTravelers);
    }

    @Override
    public Integer updateIindividualTravelers(IindividualTravelers iindividualTravelers) {
        return iindividualTravelersMapper.updateIindividualTravelers(iindividualTravelers);
    }

    @Override
    public Integer deleteIindividualTravelers(Integer id) {
        return iindividualTravelersMapper.deleteIindividualTravelers(id);
    }
}
