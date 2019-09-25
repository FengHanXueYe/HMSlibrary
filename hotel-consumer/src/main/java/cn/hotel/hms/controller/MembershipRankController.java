package cn.hotel.hms.controller;

import cn.hotel.entity.MembershipRank;
import cn.hotel.service.MembershipRankService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "msr")
public class MembershipRankController {

    @Reference
    private MembershipRankService membershipRankService;

    /**
     * ajax查询全部的会员等级
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllMembershipRank", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxQueryAllMR(){
        List<MembershipRank> membershipRanks = membershipRankService.queryAllMembershipRank();
        return JSON.toJSONString(membershipRanks);
    }


}
