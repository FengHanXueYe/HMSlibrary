package cn.hotel.hms.controller;

import cn.hotel.common.HotelCommon;
import cn.hotel.entity.ExchangeShop;
import cn.hotel.entity.Luck;
import cn.hotel.entity.LuckyDraw;
import cn.hotel.entity.MemberShipScore;
import cn.hotel.service.ExchangeShopService;
import cn.hotel.service.LuckService;
import cn.hotel.service.LuckyDrawService;
import cn.hotel.service.MemberShipScoreService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MemberShipScoreVO;
import cn.hotel.vo.MemberShipScoreVOTwo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberShipScoreController {

    @Reference
    private MemberShipScoreService memberShipScoreService;

    @Reference
    private LuckyDrawService luckyDrawService;

    @Reference
    private LuckService luckService;

    @Reference
    private ExchangeShopService exchangeShopService;
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
            memberShipScore.setMssIntegral(100);
            // 将物品减1
            luckyDraw.setLdShopNum(luckyDraw.getLdShopNum()-1);
            Integer integer1 = luckyDrawService.updateLuckyDraw(luckyDraw);
            // 重置幸运会员以及减去抽奖的幸运值100
            Integer integer = memberShipScoreService.updateMemberShipScore(memberShipScore);
            System.out.println(memberShipScore+"-----"+integer);
            return JSON.toJSONString(luckyDraw);
        }else{
            return null;
        }
    }

    /**
     * 去兑换物品页面
     * @return
     */
    @RequestMapping(value = "toExchangeShop")
    public String toExchangeShop(Model model){
        List<LuckyDraw> luckyDraws = luckyDrawService.queryAllLuckyDraw();
        Map<String,List<LuckyDraw>> map = new HashMap<>();
        List<LuckyDraw> listOne = new ArrayList<>();
        List<LuckyDraw> listTwo = new ArrayList<>();
        for(int a = 0; a<luckyDraws.size(); a++){
            if(a<3){
                listOne.add(luckyDraws.get(a));
            }else{
                listTwo.add(luckyDraws.get(a));
            }
        }
        map.put("listOne",listOne);
        map.put("listTwo",listTwo);
        model.addAttribute("map",map);
        System.out.println(map);
        return "personnel/exchangeShop";
    }

    /**
     * 查询积分大于100
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllGtIOO",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String ajaxQueryAllGtIOO(String mNumber){
        List<MemberShipScoreVOTwo> memberShipScoreVOTwos = memberShipScoreService.detailMemberShipScoreVOTwo(mNumber);
        if(memberShipScoreVOTwos.size()==1){
            return JSON.toJSONString(memberShipScoreVOTwos);
        }else{
            return null;
        }
    }


    /**
     * 兑换
     * @param exchangeShop
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxExchangShop",method = RequestMethod.POST)
    public boolean ajaxExchangShop(ExchangeShop exchangeShop){
        System.out.println(">>>>------"+exchangeShop);
        MemberShipScoreVO memberShipScoreVO = memberShipScoreService.detailOne(exchangeShop.getEsMId());
        LuckyDraw luckyDraw1 = luckyDrawService.detailLuckyDraw(exchangeShop.getEsLdId());
        if(memberShipScoreVO.getMssIntegral()<luckyDraw1.getLdShopIntegral()){
            return false;
        }
        luckyDraw1.setLdShopNum(luckyDraw1.getLdShopNum()-1);
        // 修改物品数量
        Integer integer1 = luckyDrawService.updateLuckyDraw(luckyDraw1);

        MemberShipScoreVO memberShipScoreVO1 = memberShipScoreService.detailOne(exchangeShop.getEsMId());
        MemberShipScore memberShipScore = new MemberShipScore();
        memberShipScore.setMssIntegral(luckyDraw1.getLdShopIntegral());
        memberShipScore.setMssId(memberShipScoreVO1.getMssId());
        // 修改会员积分
        Integer integer2 = memberShipScoreService.updateMemberShipScore(memberShipScore);
        System.out.println(memberShipScore+"==="+integer2+"---"+integer1);
        Integer integer = exchangeShopService.insertExchangeShop(exchangeShop);
        return integer1>0&&integer2>0?true:false;
    }


}
