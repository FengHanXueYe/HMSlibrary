package cn.hotel.service;

import cn.hotel.entity.Member;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MemberVO;

/**
 * 会员信息service
 */
public interface MemberService {


    PageUtil<MemberVO> queryAllMemberPage(Member member, Integer pageNum, Integer pageSize);

    // 查询单个会员信息
    Member detailMember(Member member);

    // 增加会员信息
    Integer insertMember(Member member);

    // 编辑会员信息
    Integer updateMember(Member member);

    // 删除会员信息
    Integer deleteMember(Integer mId);






}
