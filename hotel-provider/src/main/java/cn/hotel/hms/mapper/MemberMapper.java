package cn.hotel.hms.mapper;

import cn.hotel.entity.Member;
import cn.hotel.vo.MemberVO;

import java.util.List;

public interface MemberMapper {

    // 查询单个会员信息
    Member detailMember(Member member);

    MemberVO detailMemberXP(Member member);

    // 增加会员信息
    Integer insertMember(Member member);

    // 编辑会员信息
    Integer updateMember(Member member);

    // 删除会员信息
    Integer deleteMember(Integer mId);

    // 查询会员信息
    List<MemberVO> queryAllMember(Member member);

    Integer selectMId();

}
