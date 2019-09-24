package cn.hotel.service;

import cn.hotel.entity.Operator;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.OperatorVO;

import java.util.List;

/**
 * 操作人员接口（峰）
 */
public interface OperatorService {

    // 查询操作人员列表分页
    PageUtil<OperatorVO> queryAllOperatorPage(Operator operator, Integer pageNum, Integer pageSize);

    // 查询单个操作人员
    OperatorVO detailOperator(Integer oId);

    // 编辑操作人员信息
    Integer updateOperator(Operator operator);

    // 增加操作人员信息
    Integer insertOperator(Operator operator);

    // 删除操作人员
    Integer deleteOperator(Integer oId);

    // 验证查询
    Operator verificationOperator(Operator operator);

    // 查询所有的人员无条件
    List<Operator> queryAllOperator();

    // 登录
    OperatorVO loginUser(Operator operator);

    // 查询排班人员
    List<Operator> queryAllOperatorAndScheduling();


}
