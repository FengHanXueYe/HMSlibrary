package cn.hotel.hms.controller;

import cn.hotel.entity.SetMeal;
import cn.hotel.service.SetMealService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.SetMealVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SetMealController {

    @Reference
    private SetMealService setMealService;

    @RequestMapping(value = "queryAllMeal")
    public String toSetMeal(){
        return "food/meal_list";
    }

    @ResponseBody
    @RequestMapping(value = "queryAllSetMeal", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String queryAllSetMeal(SetMeal setMeal, Integer pageNum, Integer pageSize){
        if (pageNum==-1){
            pageNum = null;
        }
        PageUtil<SetMealVO> setMealVOPageUtil=setMealService.queryAllSetMeal(setMeal,pageNum,pageSize);
        for (SetMealVO food : setMealVOPageUtil.getList()) {
            System.out.println(""+food);
        }
        return JSON.toJSONString(setMealVOPageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "DetailSetMeal", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String detailSetMeal(Integer id){
        SetMealVO setMealVO=setMealService.detailSetMeal(id);
        return JSON.toJSONString(setMealVO);
    }

    @ResponseBody
    @RequestMapping(value = "deleteSetMeal", method = RequestMethod.POST)
    public boolean deleteSetMeal(Integer id){
        Integer setmeal=setMealService.deleteSetMeal(id);
        return setmeal>0?true:false;
    }

}
