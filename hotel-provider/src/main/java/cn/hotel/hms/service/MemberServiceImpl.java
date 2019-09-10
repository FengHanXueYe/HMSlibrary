package cn.hotel.hms.service;

import cn.hotel.entity.Member;
import cn.hotel.hms.mapper.MemberMapper;
import cn.hotel.service.MemberService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MemberVO;
import com.alibaba.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public PageUtil<MemberVO> queryAllMemberPage(Member member, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<MemberVO> list = memberMapper.queryAllMember(member);
        PageInfo<MemberVO> pageInfo = new PageInfo<>(list);
        PageUtil<MemberVO> pageUtil = new PageUtil<>();
        pageUtil.setList(pageInfo.getList());
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setTotalPageCount(pageInfo.getPages());
        pageUtil.setPageSize(pageInfo.getPageSize());
        System.out.println(pageInfo.getPages()+"++++"+pageUtil.getTotalPageCount());
        return pageUtil;
    }

    @Override
    public Member detailMember(Member member) {
        return memberMapper.detailMember(member);
    }

    @Override
    public Integer insertMember(Member member) {
        return memberMapper.insertMember(member);
    }

    @Override
    public Integer updateMember(Member member) {
        return memberMapper.updateMember(member);
    }

    @Override
    public Integer deleteMember(Integer mId) {
        return memberMapper.deleteMember(mId);
    }
}
