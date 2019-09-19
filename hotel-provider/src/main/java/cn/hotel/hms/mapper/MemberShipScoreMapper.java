package cn.hotel.hms.mapper;

import cn.hotel.entity.MemberShipScore;
import cn.hotel.vo.MemberShipScoreVO;
import cn.hotel.vo.MemberShipScoreVOTwo;

import java.util.List;

public interface MemberShipScoreMapper {

    // 查询可以抽奖的会员
    List<MemberShipScoreVO> queryAllMemberShipScore();

    // 修改抽奖会员
    Integer updateMemberShipScore(MemberShipScore memberShipScore);

    Integer updateMemberShioScoreSave(MemberShipScore memberShipScore);

    MemberShipScoreVO detailMemberShipScoreVO();

    MemberShipScoreVO detailMSSV(Integer mssStatus);

    List<MemberShipScoreVO> ListdetailMSSV(Integer mssId);

    List<MemberShipScoreVOTwo> detailMemberShipScoreVOTwo(String mNumber);
}
