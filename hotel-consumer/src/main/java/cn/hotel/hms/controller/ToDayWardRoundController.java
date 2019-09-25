package cn.hotel.hms.controller;

import cn.hotel.entity.ToDayWardRound;
import cn.hotel.entity.WardRound;
import cn.hotel.service.ToDayWardRoundService;
import cn.hotel.service.WardRoundService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ToDayWardRoundVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToDayWardRoundController {

    @Reference
    private ToDayWardRoundService toDayWardRoundService;

    @Reference
    private WardRoundService wardRoundService;

    /**
     * 去今日查房信息页面
     * @return
     */
    @RequestMapping(value = "toTDWRV")
    public String toTDWRV(){
        return "personnel/toDayWardRound";
    }

    /**
     * ajax查询今日查房信息列表
     * @param toDayWardRound
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllTDWRV", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxQueryAllTDWRV(ToDayWardRound toDayWardRound, Integer pageNum, Integer pageSize){
        PageUtil<ToDayWardRoundVO> pageUtil = toDayWardRoundService.queryAllToDayWardRoundPage(toDayWardRound, pageNum, pageSize);
        return JSON.toJSONString(pageUtil);
    }

    /**
     * 单点查询
     * @param tdwrId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxDetailTDWRV", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxDetailTDWRV(Integer tdwrId){
        ToDayWardRoundVO toDayWardRoundVO = toDayWardRoundService.detailTDWRV(tdwrId);
        return JSON.toJSONString(toDayWardRoundVO);
    }

    /**
     * 查房操作
     * @param toDayWardRound
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxUpdateTDWRV", method = RequestMethod.POST)
    public boolean ajaxUpdateTDWRV(ToDayWardRound toDayWardRound){
        System.out.println(">>>>>>>"+toDayWardRound);
        Integer integer = toDayWardRoundService.updateToDayWardRound(toDayWardRound);
        if(integer>0){
            WardRound wardRound = new WardRound();
            wardRound.setWrDetail(toDayWardRound.getTdwrDetail());
            wardRound.setWrOId(toDayWardRound.getTdwrOId());
            wardRound.setWrToDay(2);
            wardRound.setWrStatus(1);
            wardRound.setWrRoomNumber(toDayWardRound.getTdwrRoomNumber());
            wardRoundService.insertWardRoundVO(wardRound);
        }else{
            return false;
        }
        return integer>0?true:false;
    }

    /**
     * 删除今日查房信息
     * @param tdwrId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxDeleteTDWRV", method = RequestMethod.POST)
    public boolean ajaxDeleteTDWRV(Integer tdwrId){
        Integer integer = toDayWardRoundService.deleteToDayWardRound(tdwrId);
        return integer>0?true:false;
    }




}
