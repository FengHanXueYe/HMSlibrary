package cn.hotel.hms.controller;

import cn.hotel.dto.ConsumptionRecordDto;
import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.entity.DataStatus;
import cn.hotel.entity.Remind;
import cn.hotel.service.ConsumptionRecordService;
import cn.hotel.service.DataStatusService;
import cn.hotel.service.RemindService;
import cn.hotel.utils.PageUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-26 15:49
 */
@Controller
@RequestMapping("remind")
public class RemindController {

    @Reference
    private RemindService remindService;

    @Reference
    private ConsumptionRecordService consumptionRecordService;

    @Reference
    private DataStatusService dataStatusService;

    @RequestMapping("queryAllConSumptionRecord")
    public String queryAllConSumptionRecord(ConsumptionRecordDto consumptionRecordDto, Integer pageNo, Integer pageSize, Model model){
        PageUtil<ConsumptionRecord> consumptionRecordPageUtil = consumptionRecordService.queryAllByConsumptionRecore(consumptionRecordDto, pageNo, pageSize);
        List<DataStatus> bill_status =dataStatusService.queryByCode("BILL_STATUS");
        List<DataStatus> ConSumptions =dataStatusService.queryByCode("CONSUMPTION_TYPE");
        model.addAttribute("consumptionRecords",consumptionRecordPageUtil);
        model.addAttribute("bill_status",bill_status);
        model.addAttribute("ConSumptions",ConSumptions);
        return "receptionroom/storageroom_consumptionRecoreAll";
    }

    @RequestMapping(value = "doAddRemind",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject doAddRemind(Remind remind){
        remind.setRdConTime(new Date());
        JSONObject json=null;
        Integer add =null;
        try {
            add = remindService.addRemind(remind);
        } catch (Exception e) {
            json=new JSONObject();
            json.put("code",1);
            json.put("msg","系统出现错误");
            e.printStackTrace();
            return json;
        }
        if(add>0){
            json=new JSONObject();
            json.put("code",0);
            json.put("msg","发送提醒成功");
            return json;
        }
        json=new JSONObject();
        json.put("code",1);
        json.put("msg","发送提醒失败");
        return json;
    }
    @RequestMapping(value = "doUpdateRemind",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject doUpdateRemind(Remind remind){
        JSONObject json=null;
        Integer add =null;
        try {
            add = remindService.updateRemind(remind);
        } catch (Exception e) {
            json=new JSONObject();
            json.put("code",1);
            json.put("msg","系统出现错误");
            e.printStackTrace();
            return json;
        }
        if(add>0){
            json=new JSONObject();
            json.put("code",0);
            return json;
        }
        json=new JSONObject();
        json.put("code",1);
        return json;
    }

    @RequestMapping(value = "doDelRemind",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject doDelRemind(Integer reId){
        JSONObject json=null;
        Integer add =null;
        try {
            add = remindService.delRemind(reId);
        } catch (Exception e) {
            json=new JSONObject();
            json.put("code",1);
            json.put("msg","系统出现错误");
            e.printStackTrace();
            return json;
        }
        if(add>0){
            json=new JSONObject();
            json.put("code",0);
            json.put("msg","删除消息成功");
            return json;
        }
        json=new JSONObject();
        json.put("code",1);
        json.put("msg","删除失败");
        return json;
    }

    @RequestMapping(value = "queryRemindByReId",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject queryRemindByReId(String rdRoomNumber){

        JSONObject json=new JSONObject();
        ConsumptionRecord consumptionRecord = consumptionRecordService.queryConsumptionRecordByconBillNumber(rdRoomNumber);

        json.put("consumptionRecord",consumptionRecord);

        return json;
    }

    @RequestMapping("queryAllRemind")
    public String queryAllRemind(Remind remind, Model model){
        System.out.println(remind);
        List<Remind> reminds = remindService.queryRemindAll(remind);
        List<DataStatus> bill_status =dataStatusService.queryByCode("BILL_STATUS");
        List<DataStatus> ConSumptions =dataStatusService.queryByCode("CONSUMPTION_TYPE");
        model.addAttribute("bill_status",bill_status);
        model.addAttribute("ConSumptions",ConSumptions);
        model.addAttribute("reminds",reminds);
        return "receptionroom/storageroom_meal";

    }
}
