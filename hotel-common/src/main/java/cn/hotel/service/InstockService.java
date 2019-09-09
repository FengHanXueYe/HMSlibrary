package cn.hotel.service;

import cn.hotel.entity.WZXInstock;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.InstockVO;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 20:23
 */
public interface InstockService {

    /**
     * 添加进库单
     * @param wzxInstock
     * @return
     */
    Integer addInstock(WZXInstock wzxInstock);

    /**
     * #查询所有入库信息
     * @param instockVO 根据库房、商品名称、负责人查询
     * @return
     */
    PageUtil<InstockVO>  queryAllInstockVOByInstock(InstockVO instockVO,Integer pageNo,Integer pageSize);
}
