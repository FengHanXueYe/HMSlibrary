package cn.hotel.hms.controller;

import cn.hotel.service.SchedulingService;
import cn.hotel.vo.SchedulingVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "scheduling")
public class SchedulingController {

    @Reference
    private SchedulingService schedulingService;

    // 去排班页面
    @RequestMapping(value = "toScheduling")
    public String toScheduling(){
        return "personnel/scheduling";
    }

    // ajax查询排班
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllScheduling", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxQueryAllScheduling(){
        List<SchedulingVO> schedulingVOS = schedulingService.queryAllScheduling();
        for (SchedulingVO schedulingVO : schedulingVOS) {
            System.out.println(">>>>----"+schedulingVO);
        }
        return JSON.toJSONString(schedulingVOS);
    }







}
