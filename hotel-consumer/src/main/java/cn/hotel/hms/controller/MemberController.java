package cn.hotel.hms.controller;

import cn.hotel.entity.Member;
import cn.hotel.service.MemberService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MemberVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController  {

    @Reference
    private MemberService memberService;

    /**
     * 去会员信息页面
     * @return
     */
    @RequestMapping(value = "toMember")
    public String toMember(){
        // 此处权限验证
        return "personnel/Members";
    }

    /**
     * ajax查询会员信息
     * @param member
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllMember", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxQueryAllMember(Member member, Integer pageNum, Integer pageSize){
        System.out.println(member+">>>>>>>>>"+pageSize);
        PageUtil<MemberVO> pageUtil = memberService.queryAllMemberPage(member, pageNum, pageSize);
        return JSON.toJSONString(pageUtil);
    };









}
