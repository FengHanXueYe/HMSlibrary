package cn.hotel.hms.service;

import cn.hotel.entity.WZXOutStock;
import cn.hotel.hms.mapper.MaterialsInfoMapper;
import cn.hotel.hms.mapper.OutStockMapper;
import cn.hotel.service.OutStockService;
import cn.hotel.utils.PageUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 13:48
 */
@Service
public class OutStockServiceImpl implements OutStockService {
    @Autowired
    private OutStockMapper outStockMapper;

    @Autowired
    private MaterialsInfoMapper materialsInfoMapper;
    @Override
    public Integer addOutStock(WZXOutStock wzxOutStock) {
        //修改实际库存数量
        materialsInfoMapper.UpdatedelMaterialsInfoByMaterialsId(wzxOutStock);
        //添加出库单
        return outStockMapper.addOutStock(wzxOutStock);
    }

    @Override
    public PageUtil<OutStockVO> queryAllOutStockVO(OutStockVO outStockVO, Integer pageNum, Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=5;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageUtil<OutStockVO> pageUtil=new PageUtil<>();
        List<OutStockVO> stockVOS = outStockMapper.queryAllOutStockVO(outStockVO);
        PageInfo<OutStockVO> info=new PageInfo<>(stockVOS);
        pageUtil.setTotalPageCount(info.getPages());
        pageUtil.setPageNo(info.getPageNum());
        pageUtil.setPageSize(info.getSize());
        pageUtil.setNavigatepageNums(info.getNavigatepageNums());
        pageUtil.setList(info.getList());
        return pageUtil;
    }

    @Override
    public OutStockVO queryAllOutStockVOByOsId(Integer osId) {
        return outStockMapper.queryAllOutStockVOByOsId(osId);
    }

    @Override
    public Integer updateOutStock(WZXOutStock wzxOutStock) {
        return outStockMapper.updateOutStock(wzxOutStock);
    }

    @Override
    public Integer delOutStock(Integer osId) {
        return outStockMapper.delOutStock(osId);
    }
}
