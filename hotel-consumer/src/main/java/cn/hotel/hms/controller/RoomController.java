package cn.hotel.hms.controller;


import cn.hotel.entity.Member;
import cn.hotel.entity.Room;
import cn.hotel.service.MemberService;
import cn.hotel.service.RoomService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.RoomVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.data.Id;
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

    @Reference
    private MemberService memberService;

    //客房首页查询
    @RequestMapping(value = "queryAll")
    public String queryAll(Room room, Integer pageNum, Integer pageSize, Model model){
        System.out.println("++++++++++++++++"+room);
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 30;
        }

        PageUtil<RoomVO> pageUtil = roomService.queryAll(room, pageNum, pageSize);
        model.addAttribute("pageUtil",pageUtil);
        for (RoomVO room1 : pageUtil.getList()) {
            System.out.println(">>>>>>>>>>>>>"+room1);
        }
        model.addAttribute("room",room);

        return "room/room_main";
    }

    //入住
    @RequestMapping(value = "toRoomCheckIn")
    public String toRoomCheckIn(String no,Model model){
        RoomVO roomVO = roomService.queryByNumber(no);
        model.addAttribute("room",roomVO);
        return "room/room_checkIn";
    }

    //验证会员身份
    @RequestMapping(value = "verificationVIP",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"} )
    @ResponseBody
    public String verificationVIP(Member member){
        System.out.println(member.getmSFZ()+member.getmSFZtype()+member.getmName());
        Member member1 = memberService.detailMember(member);
        return JSON.toJSONString(member1);
    }

}
