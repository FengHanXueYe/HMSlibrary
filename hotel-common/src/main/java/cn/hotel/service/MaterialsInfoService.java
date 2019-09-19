package cn.hotel.service;

import cn.hotel.entity.WZXInstock;
import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXOutStock;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MaterialsInfoVO;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 20:26
 */
public interface MaterialsInfoService {
    /**
     * 添加物品信息
     * @param wzxMaterialsInfo
     * @return
     */
    Integer addMaterialsInfo(WZXMaterialsInfo wzxMaterialsInfo);

    /**
     * 查询商品编码是否存在，若存在则返回ture
     * @param materialsBarCode：商品编码
     * @return
     */
    Boolean queryMaterialsInfoBymaterialsBarCode(String materialsBarCode);

    /**
     * 根据商品materialsId查询指定商品信息
     * @param materialsId 物品表Id
     * @return
     */
    WZXMaterialsInfo  queryMaterialsInfoByMaterialsId(Integer materialsId);

    /**
     * 增加实际库存数量
     * @param wzxInstock
     * @return
     */
    Integer UpdateMaterialsInfoByMaterialsId(WZXInstock wzxInstock);

    /**
     * 减少实际库存数量
     * @param wzxInstock
     * @return
     */
    Integer UpdatedelMaterialsInfoByMaterialsId(WZXOutStock wzxInstock);

    /**
     * #查询所有物品 根据物品名称、是否库存警报、供应商、条形码查询
     * @param wzxMaterialsInfo
     * @param pageNo  当前页
     * @param pageSize  当前页数据数量
     * @return
     */
    PageUtil<MaterialsInfoVO>  queryAllMaterialsInfoVO(WZXMaterialsInfo wzxMaterialsInfo,Integer pageNo,Integer pageSize);


    /**
     * 修改物品信息
     * @param wzxMaterialsInfo
     * @return
     */
    Integer updateMaterialsInfo(WZXMaterialsInfo wzxMaterialsInfo);

    /**
     * 删除物品
     * @param materialsId
     * @return
     */
    Integer delMaterialsInfo(Integer materialsId);
}
