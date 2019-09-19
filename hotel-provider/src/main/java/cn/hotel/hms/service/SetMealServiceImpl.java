package cn.hotel.hms.service;

import cn.hotel.entity.SetMeal;
import cn.hotel.hms.mapper.SetMealMapper;
import cn.hotel.service.SetMealService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.SetMealVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SetMealServiceImpl  implements SetMealService {

    @Autowired
    private SetMealMapper setMealMapper;

    @Override
    public PageUtil<SetMealVO> queryAllSetMeal(SetMeal setMeal, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<SetMealVO> setMealVOS = setMealMapper.queryAllSetMeal(setMeal);
        PageInfo<SetMealVO> pageInfo = new PageInfo<>(setMealVOS);
        PageUtil<SetMealVO> pageInfoUtil = new PageUtil<>();
        pageInfoUtil.setList(pageInfo.getList());
        pageInfoUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageNo(pageInfo.getPageNum());
        pageInfoUtil.setTotalPageCount(pageInfo.getPages());
        pageInfoUtil.setPageSize(pageInfo.getPageSize());
        return pageInfoUtil;
    }

    @Override
    public Integer deleteSetMeal(Integer id) {
        return setMealMapper.deleteSetMeal(id);
    }

    @Override
    public Integer updateSetMeal(SetMeal setMeal) {
        return setMealMapper.updateSetMeal(setMeal);
    }

    @Override
    public Integer addSetMeal(SetMeal setMeal) {
        return setMealMapper.addSetMeal(setMeal);
    }

    @Override
    public SetMealVO detailSetMeal(Integer id) {
        return setMealMapper.detailSetMeal(id);
    }

    @Override
    public SetMeal detaSetMeal(Integer id) {
        return setMealMapper.detaSetMeal(id);
    }
}
