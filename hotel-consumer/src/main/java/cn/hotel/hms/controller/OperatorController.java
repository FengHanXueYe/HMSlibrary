package cn.hotel.hms.controller;

import cn.hotel.entity.Operator;
import cn.hotel.service.OperatorService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.OperatorVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "operator")
public class OperatorController {

    @Reference
    private OperatorService operatorService;

    @RequestMapping(value = "toOperator")
    public String toOperator(){
        return "personnel/Operator";
    }

    /**
     * ajax查询操作人员列表信息
     * @param operator 查询条件
     * @param pageNum 当前页
     * @param pageSize 每页数据量
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxQueryOperators", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxQueryOperators(Operator operator, Integer pageNum, Integer pageSize){
        if (pageNum==-1){
            pageNum = null;
        }
        PageUtil<OperatorVO> pageInfoUtil = operatorService.queryAllOperatorPage(operator, pageNum, pageSize);
        for (OperatorVO operatorVO : pageInfoUtil.getList()) {
            System.out.println(">>>>>>>>>>>"+operatorVO);
        }
        return JSON.toJSONString(pageInfoUtil);
    }

    /**
     * 去增加操作人员页面
     * @return
     */
    @RequestMapping(value = "toInsertOperator")
    public String toInsertOperator(){
        return "personnel/insertOperator";
    }

    /**
     * 执行增加操作人员
     * @param operator
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "doInsertOperator", method = RequestMethod.POST)
    public boolean doInsertOperator(Operator operator){
        Integer integer = operatorService.insertOperator(operator);
        return integer>0?true:false;
    }

    /**
     * 执行编辑操作
     * @param operator
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "doUpdateOperator")
    public boolean doUpdateOperator(Operator operator){
        Integer integer = operatorService.updateOperator(operator);
        return integer>0?true:false;
    }

    /**
     * 执行删除操作人员
     */
    @ResponseBody
    @RequestMapping(value = "doDeleteOperator", method = RequestMethod.POST)
    public boolean doDeleteOperator(Integer oId){
        Integer integer = operatorService.deleteOperator(oId);
        return integer>0?true:false;
    }

    /**
     * ajax查询操作人员详情
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "doDetailOperator", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String doDetailOperator(Integer oId){
        OperatorVO operator = operatorService.detailOperator(oId);
        return JSON.toJSONString(operator);
    }



}
