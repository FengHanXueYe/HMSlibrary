package cn.hotel.hms.service;

import cn.hotel.entity.Member;
import cn.hotel.hms.mapper.MemberMapper;
import cn.hotel.service.MemberService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member detailMember(Member member) {
        return memberMapper.detailMember(member);
    }

    @Override
    public Integer insertMember(Member member) {
        return null;
    }
}
