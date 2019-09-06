package cn.hotel.hms.mapper;

import cn.hotel.entity.Operator;
import cn.hotel.utils.PageInfoUtil;

import java.util.List;

public interface OperatorMapper {

    // 查询操作人员列表分页
    List<Operator> queryAllOperators(Operator operator);

    // 查询单个操作人员
    Operator detailOperator(Integer oId);

    // 编辑操作人员信息
    Integer updateOperator(Operator operator);

    // 增加操作人员信息
    Integer insertOperator(Operator operator);

    // 删除操作人员
    Integer deleteOperator(Integer oId);


}
