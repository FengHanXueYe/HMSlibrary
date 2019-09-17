package cn.hotel.hms.controller;

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

import java.util.List;

@Controller
public class MemberShipScoreController {

    @Reference
    private MemberShipScoreService memberShipScoreService;

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








}
