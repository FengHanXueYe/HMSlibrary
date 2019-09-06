package cn.hotel.hms.service;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.hms.mapper.DeliciousFoodMapper;
import cn.hotel.service.DeliciousFoodService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.DeliciousFoodVo;
import cn.hotel.vo.OperatorVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DeliciousFoodServiceImpl implements DeliciousFoodService {

    @Autowired
    private DeliciousFoodMapper deliciousFoodMapper;

    @Override
    public PageUtil<DeliciousFoodVo> queryAllFood(DeliciousFood deliciousFood, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<DeliciousFoodVo> deliciousFoodVos = deliciousFoodMapper.queryAllFood(deliciousFood);
        PageInfo<DeliciousFoodVo> pageInfo = new PageInfo<>(deliciousFoodVos);
        PageUtil<DeliciousFoodVo> pageInfoUtil = new PageUtil<>();
        pageInfoUtil.setList(pageInfo.getList());
        pageInfoUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageNo(pageInfo.getPageNum());
        pageInfoUtil.setTotalPageCount(pageInfo.getPages());
        pageInfoUtil.setPageSize(pageInfo.getPageSize());
        return pageInfoUtil;
    }

    @Override
    public Integer addDeliciousFood(DeliciousFood deliciousFood) {
        return deliciousFoodMapper.addDeliciousFood(deliciousFood);
    }

    @Override
    public Integer deleteDeliciousFood(Integer id) {
        return deliciousFoodMapper.deleteDeliciousFood(id);
    }

    @Override
    public DeliciousFoodVo detailDeliciousFood(Integer id) {
        return deliciousFoodMapper.detailDeliciousFood(id);
    }

    @Override
    public Integer updateDeliciousFood(DeliciousFood deliciousFood) {
        return deliciousFoodMapper.updateDeliciousFood(deliciousFood);
    }
}
