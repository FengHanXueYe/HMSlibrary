package cn.hotel.service;

import cn.hotel.entity.WZXActualStock;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ActualsStockVO;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 10:22
 */
public interface ActualsStockVoService {

    //实际库存查询 根据库房、货品名称、是否停用、条形码、货物警报查询
    PageUtil<ActualsStockVO> queryAll(ActualsStockVO actualsStockVO, Integer pageNo, Integer pageNum);


    /**
     * 根据主键asNumber查询实际库存信息
     * @param asNumber
     * @return
     */
    WZXActualStock  queryActualStockByasNumber(Integer asNumber);

    /**
     * 删除实际库存
     * @param asNumber
     * @return
     */
    Integer delActualStockByasNumber(Integer asNumber);
}
