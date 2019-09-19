package cn.hotel.hms.controller;

import cn.hotel.common.HotelCommon;
import cn.hotel.entity.Luck;
import cn.hotel.entity.LuckyDraw;
import cn.hotel.entity.MemberShipScore;
import cn.hotel.service.LuckService;
import cn.hotel.service.LuckyDrawService;
import cn.hotel.service.MemberShipScoreService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MemberShipScoreVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Controller
public class MemberShipScoreController {

    @Reference
    private MemberShipScoreService memberShipScoreService;

    @Reference
    private LuckyDrawService luckyDrawService;

    @Reference
    private LuckService luckService;
    /**
     * 查询会员抽奖信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxqueryAllMSS", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxqueryAllMSS(Integer pageNum, Integer pageSize){
        PageUtil<MemberShipScoreVO> pageUtil = memberShipScoreService.queryAllMSSPage(pageNum, pageSize);
        return JSON.toJSONString(pageUtil);
    }

    /**
     * 获取幸运会员
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxGetMSS",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String ajaxGetMSS(){
        MemberShipScoreVO memberShipScoreVO = memberShipScoreService.detailMSSV(6);
        return JSON.toJSONString(memberShipScoreVO);
    }

    /**
     * 抽奖
     * @param mId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxLuck",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String ajaxLuck(Integer mId){
        System.out.println("我是抽奖者ID："+mId);
        // 获取随机的物品
        LuckyDraw luckyDraw = luckyDrawService.randomLuckDraw();
        // 实现抽奖
        Luck luck = new Luck();
        luck.setLMId(mId);
        luck.setLLdId(luckyDraw.getLdId());
        Integer luck1 = luckService.insertLuck(luck);
        if(luck1>0){
            // 消除今天的幸运会员
            MemberShipScoreVO memberShipScoreVO = memberShipScoreService.detailMSSV(6);
            MemberShipScore memberShipScore = new MemberShipScore();
            memberShipScore.setMssStatus(1);
            memberShipScore.setMssId(memberShipScoreVO.getMssId());
            Integer integer = memberShipScoreService.updateMemberShipScore(memberShipScore);
            System.out.println(memberShipScore+"-----"+integer);
            return JSON.toJSONString(luckyDraw);
        }else{
            return null;
        }
    }








}
