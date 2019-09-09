package cn.hotel.hms.service;

import cn.hotel.entity.WZXActualStock;
import cn.hotel.hms.mapper.ActualsStockMapper;
import cn.hotel.service.ActualsStockVoService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ActualsStockVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 10:42
 */
@Service
public class ActualsStockServiceImpl implements ActualsStockVoService {

    @Autowired
    private ActualsStockMapper actualsStockMapper;

    @Override
    public PageUtil<ActualsStockVO> queryAll(ActualsStockVO actualsStockVO, Integer pageNo, Integer pageNum) {
        PageUtil<ActualsStockVO> pageInfoUtil=new PageUtil<>();
        List<ActualsStockVO> actualsStockVOS = actualsStockMapper.queryAll(actualsStockVO);
        if(null == pageNo){
            pageNo = 1;
        }
        if(null == pageNum){
            pageNum = 5;
        }
        PageHelper.startPage(pageNo, pageNum);
        PageInfo<ActualsStockVO> pageInfo = new PageInfo<>(actualsStockVOS);
        pageInfoUtil.setList(pageInfo.getList());
        pageInfoUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageSize(pageInfo.getPageSize());
        pageInfoUtil.setPageNo(pageInfo.getPageNum());
        pageInfoUtil.setTotalPageCount(pageInfo.getPages());


        return pageInfoUtil;
    }

    @Override
    public WZXActualStock queryActualStockByasNumber(Integer asNumber) {
        return actualsStockMapper.queryActualStockByasNumber(asNumber);
    }

    @Override
    public Integer delActualStockByasNumber(Integer asNumber) {
        return actualsStockMapper.delActualStockByasNumber(asNumber);
    }
}
