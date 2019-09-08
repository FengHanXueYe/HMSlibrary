package cn.hotel.service;

import cn.hotel.entity.Member;

/**
 * 会员信息service
 */
public interface MemberService {

    // 查询单个会员信息
    Member detailMember(Member member);

    // 增加会员信息
    Integer insertMember(Member member);






}
