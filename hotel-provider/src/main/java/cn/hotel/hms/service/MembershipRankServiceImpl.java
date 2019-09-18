package cn.hotel.hms.service;

import cn.hotel.entity.MembershipRank;
import cn.hotel.hms.mapper.MembershipRankMapper;
import cn.hotel.service.MembershipRankService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MembershipRankServiceImpl implements MembershipRankService {

    @Autowired
    private MembershipRankMapper membershipRankMapper;

    @Override
    public MembershipRank detailMembershipRank(Integer mrId) {
        return membershipRankMapper.detailMembershipRank(mrId);
    }

    @Override
    public List<MembershipRank> queryAllMembershipRank() {
        return membershipRankMapper.queryAllMembershipRank();
    }
}
