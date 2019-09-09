package cn.hotel.hms.mapper;

import cn.hotel.entity.WZXInstock;
import cn.hotel.vo.InstockVO;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 20:33
 */
public interface InstockMapper {
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
    List<InstockVO> queryAllInstockVOByInstock(InstockVO instockVO, Integer pageNo, Integer pageSize);
}
