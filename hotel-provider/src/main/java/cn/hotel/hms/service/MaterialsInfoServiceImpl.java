package cn.hotel.hms.service;

import cn.hotel.entity.WZXInstock;
import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXOutStock;
import cn.hotel.hms.mapper.MaterialsInfoMapper;
import cn.hotel.service.MaterialsInfoService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MaterialsInfoVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 20:48
 */
@Service
public class MaterialsInfoServiceImpl implements MaterialsInfoService {

    @Autowired
    private MaterialsInfoMapper materialsInfoMapper;

    @Override
    public Integer addMaterialsInfo(WZXMaterialsInfo wzxMaterialsInfo) {
        return materialsInfoMapper.addMaterialsInfo(wzxMaterialsInfo);
    }

    @Override
    public Boolean queryMaterialsInfoBymaterialsBarCode(String materialsBarCode) {
        WZXMaterialsInfo wzxMaterialsInfo = materialsInfoMapper.queryMaterialsInfoBymaterialsBarCode(materialsBarCode);
        if(wzxMaterialsInfo!=null){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public WZXMaterialsInfo queryMaterialsInfoByMaterialsId(Integer materialsId) {
        return materialsInfoMapper.queryMaterialsInfoByMaterialsId(materialsId);
    }

    @Override
    public Integer UpdateMaterialsInfoByMaterialsId(WZXInstock wzxMaterialsInfo) {
        return materialsInfoMapper.UpdateMaterialsInfoByMaterialsId(wzxMaterialsInfo);
    }

    @Override
    public Integer UpdatedelMaterialsInfoByMaterialsId(WZXOutStock wzxInstock) {
        return materialsInfoMapper.UpdatedelMaterialsInfoByMaterialsId(wzxInstock);
    }

    @Override
    public PageUtil<MaterialsInfoVO> queryAllMaterialsInfoVO(WZXMaterialsInfo wzxMaterialsInfo, Integer pageNo, Integer pageSize) {
        PageUtil<MaterialsInfoVO> pageInfoUtil=new PageUtil<>();
        List<MaterialsInfoVO> actualsStockVOS = materialsInfoMapper.queryAllMaterialsInfoVO(wzxMaterialsInfo);
        if(null == pageNo){
            pageNo = 1;
        }
        if(null == pageSize){
            pageSize = 5;
        }
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<MaterialsInfoVO> pageInfo = new PageInfo<>(actualsStockVOS);
        pageInfoUtil.setList(pageInfo.getList());
        pageInfoUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageSize(pageInfo.getPageSize());
        pageInfoUtil.setPageNo(pageInfo.getPageNum());
        pageInfoUtil.setTotalPageCount(pageInfo.getPages());


        return pageInfoUtil;
    }

    @Override
    public Integer updateMaterialsInfo(WZXMaterialsInfo wzxMaterialsInfo) {
        return materialsInfoMapper.updateMaterialsInfo(wzxMaterialsInfo);
    }

    @Override
    public Integer delMaterialsInfo(Integer materialsId) {
        return materialsInfoMapper.delMaterialsInfo(materialsId);
    }
}
