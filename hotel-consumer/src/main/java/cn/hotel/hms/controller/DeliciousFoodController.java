package cn.hotel.hms.controller;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.service.DeliciousFoodService;
import cn.hotel.utils.PageInfoUtil;
import cn.hotel.vo.DeliciousFoodVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeliciousFoodController {

    @Reference
    private DeliciousFoodService deliciousFoodService;

    @RequestMapping(value = "queryAllFood")
    public String toIndex(){
        return "food/food_list";
    }

    @ResponseBody
    @RequestMapping(value = "queryAllDelicious", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String queryAllDelicious(DeliciousFood deliciousFood, Integer pageNum, Integer pageSize){
        if (pageNum==-1){
            pageNum = null;
        }
        PageInfoUtil<DeliciousFoodVo> deliciousFoodVoPageUtil=this.deliciousFoodService.queryAllFood(deliciousFood,pageNum,pageSize);
        System.out.println(deliciousFoodVoPageUtil.getPagesF());
        for (DeliciousFoodVo food : deliciousFoodVoPageUtil.getListF()) {
            System.out.println(""+food);
        }
        return JSON.toJSONString(deliciousFoodVoPageUtil);
    }
}
