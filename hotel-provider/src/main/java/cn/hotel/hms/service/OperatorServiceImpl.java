package cn.hotel.hms.service;

import cn.hotel.entity.Operator;
import cn.hotel.hms.mapper.OperatorMapper;
import cn.hotel.service.OperatorService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.OperatorVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public PageUtil<OperatorVO> queryAllOperatorPage(Operator operator, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<OperatorVO> operators = operatorMapper.queryAllOperators(operator);
        PageInfo<OperatorVO> pageInfo = new PageInfo<>(operators);
        PageUtil<OperatorVO> pageInfoUtil = new PageUtil<>();
        pageInfoUtil.setList(pageInfo.getList());
        pageInfoUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageInfoUtil.setPageNo(pageInfo.getPageNum());
        pageInfoUtil.setTotalPageCount(pageInfo.getPages());
        pageInfoUtil.setPageSize(pageInfo.getPageSize());
        return pageInfoUtil;
    }

    @Override
    public OperatorVO detailOperator(Integer oId) {
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

    @Override
    public Operator verificationOperator(Operator operator) {
        return operatorMapper.verificationOperator(operator);
    }

    @Override
    public List<Operator> queryAllOperator() {
        return operatorMapper.queryAllOperator();
    }
}
