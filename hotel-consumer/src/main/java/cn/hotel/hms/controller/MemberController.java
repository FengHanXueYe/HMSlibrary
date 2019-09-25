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
@RequestMapping(value = "member")
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
        PageUtil<MemberVO> pageUtil = memberService.queryAllMemberPage(member, pageNum, pageSize);
        return JSON.toJSONString(pageUtil);
    };

    /**
     * ajax查询会员详情
     * @param member
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxDetailMember", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxDetailMember(Member member){
        MemberVO member1 = memberService.detailMemberXP(member);
        return JSON.toJSONString(member1);
    };

    /**
     * ajax保存操作
     * @param member
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxUpdateMember", method = RequestMethod.POST)
    public boolean ajaxToUpdateMember(Member member){
        System.out.println(">>>-----"+member);
        Integer member1 = memberService.updateMember(member);
        return member1>0?true:false;
    };

    /**
     * ajax删除
     * @param mId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxDeleteMember", method = RequestMethod.POST)
    public boolean ajaxDeleteMember(Integer mId){
        System.out.println(">>>======"+mId);
        Integer member1 = memberService.deleteMember(mId);
        return member1>0?true:false;
    };


    /**
     * 去增加页面
     * @return
     */
    @RequestMapping(value = "toInsertMember")
    public String toInsertMember(){
        return "personnel/insertMember";
    }

    /**
     * 增加会员信息
     * @param member
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "doInsertMember", method = RequestMethod.POST)
    public boolean doInsertMember(Member member){
        String name = member.getmName();
        member.setmName("");
        Member member1 = memberService.detailMember(member);
        if(member1==null){
            member.setmName(name);
            Integer id = memberService.selectMId()+1;
            member.setmNumber("CESJ"+id);
            if(member.getmRemarks()==""){
                member.setmRemarks("无");
            }
            Integer integer = memberService.insertMember(member);
            return true;
        }else{
            return false;
        }
    }





}
