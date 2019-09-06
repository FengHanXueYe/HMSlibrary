package cn.hotel.hms.controller;


import cn.hotel.entity.Room;
import cn.hotel.service.RoomService;
import cn.hotel.utils.PageUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "room")
public class RoomController {

    @Reference
    private RoomService roomService;

    @RequestMapping(value = "queryAll")
    public String queryAll(Room room, Integer pageNum, Integer pageSize, Model model){
        System.out.println("++++++++++++++++"+room);
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 30;
        }

        PageUtil<Room> pageUtil = roomService.queryAll(room, pageNum, pageSize);
        model.addAttribute("pageUtil",pageUtil);
        for (Room room1 : pageUtil.getList()) {
            System.out.println(">>>>>>>>>>>>>"+room1);
        }
        model.addAttribute("room",room);

        return "room/room_main";
    }
}
