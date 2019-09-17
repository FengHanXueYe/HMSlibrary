package cn.hotel.hms.service;

import cn.hotel.entity.MemberShipScore;
import cn.hotel.hms.mapper.MemberShipScoreMapper;
import cn.hotel.service.MemberShipScoreService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MemberShipScoreVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service()
public class MemberShipScoreServiceImpl implements MemberShipScoreService {

    @Autowired
    private MemberShipScoreMapper memberShipScoreMapper;

    @Override
    public PageUtil<MemberShipScoreVO> queryAllMSSPage(Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 5;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<MemberShipScoreVO> memberShipScoreVOS = memberShipScoreMapper.queryAllMemberShipScore();
        PageInfo<MemberShipScoreVO> pageInfo = new PageInfo<>(memberShipScoreVOS);
        PageUtil<MemberShipScoreVO> pageUtil = new PageUtil<>();
        pageUtil.setList(pageInfo.getList());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setTotalPageCount(pageInfo.getPages());
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        return pageUtil;
    }

    @Override
    public List<MemberShipScoreVO> queryAllMemberShipScore() {
        return memberShipScoreMapper.queryAllMemberShipScore();
    }

    @Override
    public Integer updateMemberShipScore(MemberShipScore memberShipScore) {
        return memberShipScoreMapper.updateMemberShipScore(memberShipScore);
    }

    @Override
    public MemberShipScoreVO detailMemberShipScoreVO() {
        return memberShipScoreMapper.detailMemberShipScoreVO();
    }
}
