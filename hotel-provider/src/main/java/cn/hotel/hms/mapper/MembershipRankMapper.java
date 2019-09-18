package cn.hotel.hms.mapper;

import cn.hotel.entity.MembershipRank;

import java.util.List;

public interface MembershipRankMapper {

    MembershipRank detailMembershipRank(Integer mrId);

    // 查询会员等级list列表
    List<MembershipRank> queryAllMembershipRank();


}
