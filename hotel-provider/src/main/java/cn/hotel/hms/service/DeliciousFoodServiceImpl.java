package cn.hotel.hms.service;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.hms.mapper.DeliciousFoodMapper;
import cn.hotel.service.DeliciousFoodService;
import cn.hotel.utils.PageInfoUtil;
import cn.hotel.vo.DeliciousFoodVo;
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
    public PageInfoUtil<DeliciousFoodVo> queryAllFood(DeliciousFood deliciousFood, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<DeliciousFoodVo> deliciousFoods = deliciousFoodMapper.queryAllFood(deliciousFood);
        PageInfo<DeliciousFoodVo> pageInfo = new PageInfo<>(deliciousFoods);
        PageInfoUtil<DeliciousFoodVo> pageInfoUtil = new PageInfoUtil<>();
        pageInfoUtil.setListF(pageInfo.getList());
        pageInfoUtil.setNavIgtePageNumbers(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageNumF(pageInfo.getPageNum());
        pageInfoUtil.setPagesF(pageInfo.getPages());
        pageInfoUtil.setPageSizeF(pageInfo.getPageSize());
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
