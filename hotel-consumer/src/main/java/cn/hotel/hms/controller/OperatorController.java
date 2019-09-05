package cn.hotel.hms.controller;

import cn.hotel.entity.Operator;
import cn.hotel.service.OperatorService;
import cn.hotel.utils.PageInfoUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
        PageInfoUtil<Operator> pageInfoUtil = operatorService.queryAllOperatorPage(operator, pageNum, pageSize);
        return JSON.toJSONString(pageInfoUtil);
    }

    /**
     * 去增加操作人员页面
     * @return
     */
    @RequestMapping(value = "toInsertOperator")
    public String toInsertOperator(){
        return "insertOperator";
    }

    /**
     * 执行增加操作人员
     * @param operator
     * @return
     */
    @RequestMapping(value = "doInsertOperator")
    public String doInsertOperator(Operator operator){
        Integer integer = operatorService.insertOperator(operator);
        return "redirect:toOperator";
    }

    /**
     * 去编辑页面
     */
    @RequestMapping(value = "toUpdateOperator")
    public String toUpdateOperator(){
        return "updateOperator";
    }

    /**
     * 执行编辑操作
     * @param operator
     * @return
     */
    @RequestMapping(value = "doUpdateOperator")
    public String doUpdateOperator(Operator operator){
        Integer integer = operatorService.updateOperator(operator);
        return "redirect:toOperator";
    }

    /**
     * 执行删除操作人员
     */
    @RequestMapping(value = "doDeleteOperator")
    public String doDeleteOperator(Integer oId){
        Integer integer = operatorService.deleteOperator(oId);
        return "redirect:toOperator";
    }




}
