package cn.hotel.service;

import cn.hotel.entity.MemberShipScore;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MemberShipScoreVO;

import java.util.List;

public interface MemberShipScoreService {

    PageUtil<MemberShipScoreVO> queryAllMSSPage(Integer pageNum, Integer pageSize);

    // 查询可以抽奖的会员
    List<MemberShipScoreVO> queryAllMemberShipScore();

    // 修改抽奖会员
    Integer updateMemberShipScore(MemberShipScore memberShipScore);

    // 随机幸运会员
    MemberShipScoreVO detailMemberShipScoreVO();

    MemberShipScoreVO detailMSSV(Integer mssId);

    // 防止出错
    List<MemberShipScoreVO> ListdetailMSSV(Integer mssId);








}
