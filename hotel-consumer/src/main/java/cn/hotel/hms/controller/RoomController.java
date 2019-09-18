package cn.hotel.hms.controller;


import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.entity.Member;
import cn.hotel.entity.MembershipRank;
import cn.hotel.entity.Room;
import cn.hotel.service.*;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ConsumptionRecordVO;
import cn.hotel.vo.RoomLiveinVO;
import cn.hotel.vo.RoomVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.data.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "room")
public class RoomController {

    @Reference
    private RoomService roomService;

    @Reference
    private MemberService memberService;

    @Reference
    private MembershipRankService membershipRankService;

    @Reference
    private ConsumptionRecordService consumptionRecordService;

    @Reference
    private RoomLiveinService roomLiveinService;

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


    /*查询会员等级*/
    @RequestMapping(value = "queryLevle",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryLevle(Integer id){
        MembershipRank membershipRank = membershipRankService.detailMembershipRank(id);
        return JSON.toJSONString(membershipRank);
    }

    @RequestMapping(value = "saveRoom",method = RequestMethod.POST)
    @ResponseBody
    public String saveRoom(RoomLiveinVO roomLiveinVO){
        System.out.println(">>>>>>>>>>>>>>>房间号"+roomLiveinVO.getRoomNo());
        //这个获取的是操作人员的id
        roomLiveinVO.setrIOperator(1);
        Integer save = roomService.save(roomLiveinVO);
        if(save != -1){
            return "ok";
        }

        return "error";
    }

    //报修
    @RequestMapping(value = "updateRepairStatus",method = RequestMethod.POST)
    @ResponseBody
    public String updateRepairStatus(Room room){
        room.setRoomStatus(4);
        Integer fag = roomService.updateStatus(room);
        if(fag != -1){
            return "ok";
        }
        return "error";
    }

    @RequestMapping(value = "queryRoomRecord")
    public String queryRoomRecord(ConsumptionRecord consumptionRecord,Integer pageNo,Integer pageSize,Model model){
        if(pageNo ==null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 5;
        }
        PageUtil<ConsumptionRecordVO> pageUtil = consumptionRecordService.queryAll(consumptionRecord, pageNo, pageSize);
        System.out.println("》》》》》》》》》》》》》》》》》》》《《《《《《《《《"+pageUtil.getList());
        model.addAttribute("pageUtil",pageUtil);
        return"room/room_Record";
    }

    @RequestMapping(value = "toRoomReplace")
    public String toRoomReplace(String code,Model model){
        RoomLiveinVO roomLiveinVO = roomLiveinService.queryByidCode(code);
        model.addAttribute("roomLivein",roomLiveinVO);
        return "room/room_replace";
    }

    @RequestMapping(value = "queryRommNumber",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryRommNumber(){
        List<Room> rooms = roomService.queryRoomAllNumber();
        return JSON.toJSONString(rooms);
    }

}
