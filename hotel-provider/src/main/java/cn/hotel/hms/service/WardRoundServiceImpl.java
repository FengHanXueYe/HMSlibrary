package cn.hotel.hms.service;

import cn.hotel.entity.WardRound;
import cn.hotel.hms.mapper.WardRoundMapper;
import cn.hotel.service.WardRoundService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.WardRoundVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WardRoundServiceImpl implements WardRoundService {

    @Autowired
    private WardRoundMapper wardRoundMapper;

    @Override
    public PageUtil<WardRoundVO> queryAllWardRoundPage(WardRound wardRound, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<WardRoundVO> wardRoundVOS = wardRoundMapper.queryAllWardRoundVO(wardRound);
        PageInfo<WardRoundVO> pageInfo = new PageInfo<>(wardRoundVOS);
        PageUtil<WardRoundVO> pageUtil = new PageUtil<>();
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageUtil.setTotalPageCount(pageInfo.getPages());
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setList(pageInfo.getList());
        return pageUtil;
    }

    @Override
    public WardRoundVO detailWardRoundVO(Integer wrId) {
        return wardRoundMapper.detailWardRoundVO(wrId);
    }

    @Override
    public Integer insertWardRoundVO(WardRound wardRound) {
        return wardRoundMapper.insertWardRoundVO(wardRound);
    }

    @Override
    public Integer updateWardRound(WardRound wardRound) {
        return wardRoundMapper.updateWardRound(wardRound);
    }

    @Override
    public Integer deleteWardRound(Integer wrId) {
        return wardRoundMapper.deleteWardRound(wrId);
    }

    @Override
    public Integer updateWR(WardRound wardRound) {
        return wardRoundMapper.updateWR(wardRound);
    }
}
