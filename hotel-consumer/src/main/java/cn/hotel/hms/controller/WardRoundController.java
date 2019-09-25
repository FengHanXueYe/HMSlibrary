package cn.hotel.hms.controller;

import cn.hotel.entity.Operator;
import cn.hotel.entity.Room;
import cn.hotel.entity.WardRound;
import cn.hotel.service.OperatorService;
import cn.hotel.service.RoomService;
import cn.hotel.service.WardRoundService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.WardRoundVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "wardr")
public class WardRoundController {

    @Reference
    private WardRoundService wardRoundService;

    @Reference
    private RoomService roomService;

    @Reference
    private OperatorService operatorService;

    /**
     * 去查询页面
     * @return
     */
    @RequestMapping(value = "toWardRound")
    public String toWardRound(){
        return "personnel/wardRound";
    }
    /**
     * ajax查询查房信息
     * @param wardRound
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllWR", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxQueryAllWR(WardRound wardRound, Integer pageNum, Integer pageSize){
        System.out.println(">>>>>>>"+wardRound);
        PageUtil<WardRoundVO> pageUtil = wardRoundService.queryAllWardRoundPage(wardRound, pageNum, pageSize);
        return JSON.toJSONString(pageUtil);
    }

    /**
     * ajax单点查询
     * @param wrId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxDetailWR", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxDetailWR(Integer wrId){
        WardRoundVO wardRoundVO = wardRoundService.detailWardRoundVO(wrId);
        return JSON.toJSONString(wardRoundVO);
    }

    /**
     * 编辑查房信息
     * @param wardRound
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxUpdateWR")
    public boolean ajaxUpdateWR(WardRound wardRound){
        Integer integer = wardRoundService.updateWardRound(wardRound);
        return integer>0?true:false;
    }

    /**
     * 删除查房信息
     * @param wrId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxDeleteWR")
    public boolean ajaxDeleteWR(Integer wrId){
        Integer integer = wardRoundService.deleteWardRound(wrId);
        return integer>0?true:false;
    }

    /**
     * 去增加页面
     * @return
     */
    @RequestMapping(value = "toInsertWR")
    public String toInsertWR(){
        return "personnel/insertWardRound";
    }

    /**
     * 增加查房信息
     * @param wardRound
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxInsertWR")
    public boolean ajaxInsertWR(WardRound wardRound){
        Integer integer = wardRoundService.insertWardRoundVO(wardRound);
        return integer>0?true:false;
    }

    /**
     * 加载房间
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxLoadRoom", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxLoadRoom(){
        List<Room> rooms = roomService.queryRoomAllNumber();
        return JSON.toJSONString(rooms);
    }

    /**
     * 加载查房人员
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxLoadOperator", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxLoadOperator(){
        List<Operator> operators = operatorService.queryAllOperator();
        return JSON.toJSONString(operators);
    }



}
