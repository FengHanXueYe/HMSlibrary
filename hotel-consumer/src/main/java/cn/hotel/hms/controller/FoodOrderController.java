package cn.hotel.hms.controller;

import cn.hotel.entity.*;
import cn.hotel.service.ConsumptionRecordService;
import cn.hotel.service.FoodOrderService;
import cn.hotel.service.RoomService;
import cn.hotel.utils.CreateNumber;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.FoodOrderVo;
import cn.hotel.vo.RoomVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FoodOrderController {


    @Reference
    private FoodOrderService foodOrderService;

    @Reference
    private ConsumptionRecordService consumptionRecordService;

    @Reference
    private RoomService roomService;

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
    //去增加订单的页面
    @RequestMapping(value = "toAddFoodOrder")
    public String toAddFoodOrder(){
        return "food/add_order";
    }
    //增加订单
    @RequestMapping(value = "doAddFoodOrder")
    public String doAddFoodOrder(FoodOrder foodOrder){
        this.foodOrderService.addFoodOrder(foodOrder);
        return "redirect:toqueryAllFoodOrder";
    }

    //去修改订单的页面
    @RequestMapping(value = "toUpdateOrder")
    public String toUpdateFoodOrder(Integer id, Model model){
        model.addAttribute("order",this.foodOrderService.detailFoodOrders(id));
        return "food/update_order";
    }

    //做修改订单的操作
    @RequestMapping(value = "doUpdateOrder")
    public String doUpdateFoodOrder(FoodOrder foodOrder){
        this.foodOrderService.updateFoodOrder(foodOrder);
        return "redirect:toqueryAllFoodOrder";
    }

    // 增加订单
    @ResponseBody
    @RequestMapping(value = "ajaxInsertCAndFood", method = RequestMethod.POST)
    public boolean ajaxInsertCAndFood(String str, String name, String tel, String roomNumber, double money){
        System.out.println(str+"---"+name+"---"+tel+"---"+roomNumber);
        RoomVO roomVO = roomService.queryByNumber(roomNumber);
        // 增加订单
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setRemarks(str);
        foodOrder.setFoodsid(1);
        foodOrder.setOrderprice(money);
        foodOrder.setOrderstatus(4);
        foodOrder.setOrderRoom(roomVO.getId()+"");
        foodOrder.setUserName(name);
        foodOrder.setUserPhone(tel);
        foodOrder.setShopnumber(1);
        foodOrder.setSetmealid(1);
        Integer integer = foodOrderService.addFoodOrder(foodOrder);
        // 增加消费记录
//        ConsumptionRecord consumptionRecord = new ConsumptionRecord();
//        consumptionRecord.setConType(1);
//        consumptionRecord.setConScene("订餐");
//        consumptionRecord.setConContent("订餐");
//        consumptionRecord.setConPrice(money);
//        consumptionRecord.setConName(name);
//        consumptionRecord.setConRemarks(str);
//        // 操作人
//        consumptionRecord.setBillConfirmer(1);
//        consumptionRecord.setBillstatus(1);
//        consumptionRecord.setConBillNumber(CreateNumber.createNo("gk",null));
//        consumptionRecord.setRoomNumber(roomNumber);

        ConsumptionRecord con =new ConsumptionRecord();
        //消费类型（客房）
        con.setConType(1);
        //消费场景
        con.setConScene("订餐");
        con.setConContent("订餐");
        //客房编号
        con.setRoomNumber(roomNumber);
        //消费金额
        con.setConPrice(money);
        //消费客户名称
        con.setConName(name);
        //备注
        con.setConRemarks(str);
        //操作人
        con.setBillConfirmer(1);
        //客房类型
        con.setBillstatus(1);
        //账单编号
        con.setConBillNumber(CreateNumber.createNo("kg",null));
        Integer save = consumptionRecordService.save(con);
        return integer>0&&save>0?true:false;
    }





}
