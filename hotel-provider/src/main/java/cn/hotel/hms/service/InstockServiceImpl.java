package cn.hotel.hms.service;

import cn.hotel.entity.WZXInstock;
import cn.hotel.hms.mapper.InstockMapper;
import cn.hotel.service.InstockService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.InstockVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 20:46
 */
@Service
public class InstockServiceImpl implements InstockService {

    @Autowired
    private InstockMapper instockMapper;

    @Override
    public Integer addInstock(WZXInstock wzxInstock) {
        return instockMapper.addInstock(wzxInstock);
    }

    @Override
    public PageUtil<InstockVO> queryAllInstockVOByInstock(InstockVO instockVO, Integer pageNo, Integer pageSize) {
        PageUtil<InstockVO> pageInfoUtil=new PageUtil<>();
        List<InstockVO> actualsStockVOS = instockMapper.queryAllInstockVOByInstock(instockVO,pageNo,pageSize);
        if(null == pageNo){
            pageNo = 1;
        }
        if(null == pageSize){
            pageSize = 5;
        }
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<InstockVO> pageInfo = new PageInfo<>(actualsStockVOS);
        pageInfoUtil.setList(pageInfo.getList());
        pageInfoUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageSize(pageInfo.getPageSize());
        pageInfoUtil.setPageNo(pageInfo.getPageNum());
        pageInfoUtil.setTotalPageCount(pageInfo.getPages());


        return pageInfoUtil;
    }
}
