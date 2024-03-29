package cn.hotel.hms.mapper;

import cn.hotel.entity.WZXActualStock;
import cn.hotel.vo.ActualsStockVO;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 10:26
 */
public interface ActualsStockMapper {

    List<ActualsStockVO> queryAll(ActualsStockVO actualsStockVO);

    /**
     * 根据主键asNumber查询实际库存信息
     * @param asNumber
     * @return
     */
    WZXActualStock queryActualStockByasNumber(Integer asNumber);

    /**
     * 删除实际库存
     * @param asNumber
     * @return
     */
    Integer delActualStockByasNumber(Integer asNumber);

    /**
     * 根据物品编号查询实际库存信息
     * @param materialsNumber 物品编号
     * @return
     */
    WZXActualStock  queryActualsStockBymaterialsNumber(String materialsNumber);


    /**
     * 添加实际库存
     * @param actualsStockVO
     * @return
     */
    Integer  addActualStock(WZXActualStock actualsStockVO);
}
