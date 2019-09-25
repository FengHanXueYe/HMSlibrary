package cn.hotel.hms.controller;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.Room;
import cn.hotel.service.ConsumptionRecordService;
import cn.hotel.service.DataStatusService;
import cn.hotel.service.RoomService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "test")
public class TestController {

    @Reference
    private RoomService roomService;

    @Reference
    private DataStatusService dataStatusService;

    @RequestMapping(value = "homepage")
    public String toreception1(Model model){

        //已预约客房
        List<Room> roomListYu=roomService.queryRoomAllMake();
        //客房状态
        List<DataStatus> room_status = dataStatusService.queryByCode("ROMM_TYPE");

        model.addAttribute("roomListYu",roomListYu);
        model.addAttribute("room_status",room_status);
        return "receptionroom/homepage";
    }
}
