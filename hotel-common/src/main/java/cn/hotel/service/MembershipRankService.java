package cn.hotel.service;

import cn.hotel.entity.MembershipRank;

import java.util.List;

public interface MembershipRankService {

    // 根据会员中的会员等级外键查询会员等级信息
    MembershipRank detailMembershipRank(Integer mrId);

    // 查询会员等级list列表
    List<MembershipRank> queryAllMembershipRank();


}
