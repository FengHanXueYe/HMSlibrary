package cn.hotel.hms.service;

import cn.hotel.entity.ToDayWardRound;
import cn.hotel.hms.mapper.ToDayWardRoundMapper;
import cn.hotel.service.ToDayWardRoundService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ToDayWardRoundVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ToDayWardRoundServiceImpl implements ToDayWardRoundService {

    @Autowired
    private ToDayWardRoundMapper toDayWardRoundMapper;

    @Override
    public PageUtil<ToDayWardRoundVO> queryAllToDayWardRoundPage(ToDayWardRound toDayWardRound, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ToDayWardRoundVO> toDayWardRoundVOS = toDayWardRoundMapper.queryAllTDWRV(toDayWardRound);
        PageInfo<ToDayWardRoundVO> pageInfo = new PageInfo<>(toDayWardRoundVOS);
        PageUtil<ToDayWardRoundVO> pageUtil = new PageUtil<>();
        pageUtil.setList(pageInfo.getList());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setTotalPageCount(pageInfo.getPages());
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        return pageUtil;
    }

    @Override
    public Integer insertToDayWardRound(ToDayWardRound toDayWardRound) {
        return toDayWardRoundMapper.insertToDayWardRound(toDayWardRound);
    }

    @Override
    public Integer updateToDayWardRound(ToDayWardRound toDayWardRound) {
        return toDayWardRoundMapper.updateToDayWardRound(toDayWardRound);
    }

    @Override
    public Integer deleteToDayWardRound(Integer tdwrId) {
        return toDayWardRoundMapper.deleteToDayWardRound(tdwrId);
    }

    @Override
    public ToDayWardRoundVO detailTDWRV(Integer tdwrId) {
        return toDayWardRoundMapper.detailTDWRV(tdwrId);
    }

    @Override
    public Integer truncateTable() {
        return toDayWardRoundMapper.truncateTable();
    }
}
