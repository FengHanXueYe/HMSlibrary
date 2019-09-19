package cn.hotel.hms.service;

import cn.hotel.entity.WZXMaterialsLocation;
import cn.hotel.hms.mapper.MaterialsLocationMapper;
import cn.hotel.service.MaterialsLocationService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 14:59
 */
@Service
public class MaterialsLocationServiceImpl implements MaterialsLocationService {

    @Autowired
    private MaterialsLocationMapper materialsLocationMapper;

    @Override
    public Integer delMaterialsLocation(Integer goodsLocationNumber) {
        return materialsLocationMapper.delMaterialsLocation(goodsLocationNumber);
    }

    @Override
    public Integer addMaterialsLocation(WZXMaterialsLocation actualsStockVO) {
        Integer materialsLocation = materialsLocationMapper.addMaterialsLocation(actualsStockVO);

        return materialsLocation;
    }
}
