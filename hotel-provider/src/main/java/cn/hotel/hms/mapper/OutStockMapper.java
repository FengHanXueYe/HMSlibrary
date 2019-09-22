package cn.hotel.hms.mapper;

import cn.hotel.entity.WZXOutStock;
import cn.hotel.vo.OutStockVO;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 13:43
 */
public interface OutStockMapper {

    /**
     * 增加出库单，减少实际库房数量UpdatedelMaterialsInfoByMaterialsId（）
     * @param wzxOutStock
     * @return
     */
    Integer addOutStock(WZXOutStock wzxOutStock);

    /**
     * 出库查询  根据物品名称、编号、库房、出库时间
     * @param outStockVO
     * @return
     */
    List<OutStockVO> queryAllOutStockVO(OutStockVO outStockVO);

    /**
     * 修改出库信息
     * @param wzxOutStock
     * @return
     */
    Integer updateOutStock(WZXOutStock wzxOutStock);

    /**
     * 删除出库信息根据主键osId
     * @param osId
     * @return
     */
    Integer delOutStock(Integer osId);

    /**
     * 查询出库单具体信息
     * @param osId
     * @return
     */
    OutStockVO  queryAllOutStockVOByOsId(Integer osId);
}
