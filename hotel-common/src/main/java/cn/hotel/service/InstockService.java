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

    /**
     * 修改进货单
     * @param wzxInstock
     * @return
     */
    Integer updateInstock(WZXInstock wzxInstock);

    /**
     * 根据isId入库单主键查询详细信息
     * @param isId
     * @return
     */
    InstockVO queryAllInstockVoByIsId(Integer isId);

    /**
     * isId主键  删除入库单
     * @param isId
     * @return
     */
    Integer delInstock(Integer isId);
}
