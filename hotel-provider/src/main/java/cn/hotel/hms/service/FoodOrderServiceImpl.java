package cn.hotel.hms.service;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.entity.FoodOrder;
import cn.hotel.entity.Room;
import cn.hotel.entity.SetMeal;
import cn.hotel.hms.mapper.FoodOrderMapper;
import cn.hotel.service.FoodOrderService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.DeliciousFoodVo;
import cn.hotel.vo.FoodOrderVo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Autowired
    private FoodOrderMapper foodOrderMapper;

    @Override
    public PageUtil<FoodOrderVo> queryAllFoodOrder(FoodOrder foodOrder, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<FoodOrderVo> deliciousFoodVos = foodOrderMapper.queryAllFoodOrder(foodOrder);
        PageInfo<FoodOrderVo> pageInfo = new PageInfo<>(deliciousFoodVos);
        PageUtil<FoodOrderVo> pageInfoUtil = new PageUtil<>();
        pageInfoUtil.setList(pageInfo.getList());
        pageInfoUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageNo(pageInfo.getPageNum());
        pageInfoUtil.setTotalPageCount(pageInfo.getPages());
        pageInfoUtil.setPageSize(pageInfo.getPageSize());
        return pageInfoUtil;
    }

    @Override
    public Integer addFoodOrder(FoodOrder foodOrder) {
        return foodOrderMapper.addFoodOrder(foodOrder);
    }

    @Override
    public Integer updateFoodOrder(FoodOrder foodOrder) {
        return foodOrderMapper.updateFoodOrder(foodOrder);
    }

    @Override
    public FoodOrderVo detailFoodOrder(Integer id) {
        return foodOrderMapper.detailFoodOrder(id);
    }

    @Override
    public Integer deleteFoodOrder(Integer id) {
        return foodOrderMapper.deleteFoodOrder(id);
    }

    @Override
    public List<DeliciousFood> queryAllDeliciousFood() {
        return foodOrderMapper.queryAllDeliciousFood();
    }

    @Override
    public List<SetMeal> queryAllSetMeal() {
        return foodOrderMapper.queryAllSetMeal();
    }

    @Override
    public List<Room> queryAllRoom() {
        return foodOrderMapper.queryAllRoom();
    }
}
