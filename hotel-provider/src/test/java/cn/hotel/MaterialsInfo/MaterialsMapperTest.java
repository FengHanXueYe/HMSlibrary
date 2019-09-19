package cn.hotel.MaterialsInfo;

import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.hms.mapper.MaterialsInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 20:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MaterialsMapperTest  {

    @Autowired
    private MaterialsInfoMapper materialsInfoMapper;

    @Test
    public void test1(){
        WZXMaterialsInfo wzxMaterialsInfo = materialsInfoMapper.queryMaterialsInfoByMaterialsId(1);
        System.out.println("queryMaterialsInfoByMaterialsId:"+wzxMaterialsInfo);
        WZXMaterialsInfo wzxMaterialsInfo1 = materialsInfoMapper.queryMaterialsInfoBymaterialsBarCode("354351454");
        System.out.println("queryMaterialsInfoBymaterialsBarCode:"+wzxMaterialsInfo1);
        WZXMaterialsInfo wzxMaterialsInfo2 = materialsInfoMapper.queryMaterialsInfoByMaterialsId(1);
        wzxMaterialsInfo2.setMaterialsBarCode("135434531345");
        wzxMaterialsInfo2.setMaterialsName("测试");
        System.out.println(materialsInfoMapper.addMaterialsInfo(wzxMaterialsInfo2));
    }


}
