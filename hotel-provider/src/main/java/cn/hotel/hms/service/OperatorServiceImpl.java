package cn.hotel.hms.service;

import cn.hotel.entity.Operator;
import cn.hotel.hms.mapper.OperatorMapper;
import cn.hotel.service.OperatorService;
import cn.hotel.utils.PageInfoUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public PageInfoUtil<Operator> queryAllOperatorPage(Operator operator, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Operator> operators = operatorMapper.queryAllOperators(operator);
        PageInfo<Operator> pageInfo = new PageInfo<>(operators);
        PageInfoUtil<Operator> pageInfoUtil = new PageInfoUtil<>();
        pageInfoUtil.setListF(pageInfo.getList());
        pageInfoUtil.setNavIgtePageNumbers(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageNumF(pageInfo.getPageNum());
        pageInfoUtil.setPagesF(pageInfo.getPages());
        pageInfoUtil.setPageSizeF(pageInfo.getPageSize());
        return pageInfoUtil;
    }

    @Override
    public Operator detailOperator(Integer oId) {
        return operatorMapper.detailOperator(oId);
    }

    @Override
    public Integer updateOperator(Operator operator) {
        return operatorMapper.updateOperator(operator);
    }

    @Override
    public Integer insertOperator(Operator operator) {
        return operatorMapper.insertOperator(operator);
    }

    @Override
    public Integer deleteOperator(Integer oId) {
        return operatorMapper.deleteOperator(oId);
    }
}
