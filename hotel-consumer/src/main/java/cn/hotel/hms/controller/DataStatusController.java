package cn.hotel.hms.controller;

import cn.hotel.entity.DataStatus;
import cn.hotel.service.DataStatusService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "dataStatus")
public class DataStatusController {

    @Reference
    private DataStatusService dataStatusService;


    //根据类型code查询
    @RequestMapping(value = "queryByCode",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryByCode(String code){
        List<DataStatus> dataStatuses = dataStatusService.queryByCode(code);
        return JSON.toJSONString(dataStatuses);
    }
}
