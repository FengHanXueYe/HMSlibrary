package cn.hotel.hms.controller;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.entity.FoodOrder;
import cn.hotel.entity.Room;
import cn.hotel.entity.SetMeal;
import cn.hotel.service.FoodOrderService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.DeliciousFoodVo;
import cn.hotel.vo.FoodOrderVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.data.Id;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FoodOrderController {


    @Reference
    private FoodOrderService foodOrderService;

    @RequestMapping("toqueryAllFoodOrder")
    public String toFoodOrder(){
        return "food/order_list";
    }
    //查询全部订单
    @ResponseBody
    @RequestMapping(value = "queryAllFoodOrder", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String queryAllFoodOrder(FoodOrder foodOrder,Integer pageNum, Integer pageSize){
        if (pageNum==-1){
            pageNum = null;
        }
        PageUtil<FoodOrderVo> deliciousFoodVoPageUtil=this.foodOrderService.queryAllFoodOrder(foodOrder,pageNum,pageSize);
        System.out.println(deliciousFoodVoPageUtil.getNavigatepageNums());
        for (FoodOrderVo food : deliciousFoodVoPageUtil.getList()) {
            System.out.println("------------"+food);
        }
        return JSON.toJSONString(deliciousFoodVoPageUtil);
    }
    //加载所有房间
    @ResponseBody
    @RequestMapping(value = "queryAllRoom",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryAllRoom(){
        List<Room> list=foodOrderService.queryAllRoom();
        return JSON.toJSONString(list);
    }
    //加载所有食品
    @ResponseBody
    @RequestMapping(value = "queryAllDelicious",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    public String queryAllDeliciousFood(){
        List<DeliciousFood> list=foodOrderService.queryAllDeliciousFood();
        return JSON.toJSONString(list);
    }
    //加载所有套餐
    @ResponseBody
    @RequestMapping(value = "queryAllSetMeal",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    public String queryAllSetMeal(){
        List<SetMeal> list=foodOrderService.queryAllSetMeal();
        return JSON.toJSONString(list);
    }
    //查看单个订单的信息
    @ResponseBody
    @RequestMapping(value = "detailFoodOrder", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String detaialFoodOder(Integer id){
        FoodOrderVo foodOrderVo=foodOrderService.detailFoodOrder(id);
        return JSON.toJSONString(foodOrderVo);
    }
    //删除单个订单的信息
    @ResponseBody
    @RequestMapping(value = "deleteFoodOrder", method = RequestMethod.POST)
    public boolean deleteFoodOrder(Integer id){
        Integer foodOrder=foodOrderService.deleteFoodOrder(id);
        return foodOrder>0?true:false;
    }
}
