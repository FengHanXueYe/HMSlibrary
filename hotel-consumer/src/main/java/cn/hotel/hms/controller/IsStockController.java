package cn.hotel.hms.controller;

import cn.hotel.entity.WZXInstock;
import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.service.*;
import cn.hotel.utils.MyDigitUtils;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ActualsStockVO;
import cn.hotel.vo.InstockVO;
import cn.hotel.vo.MaterialsInfoVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 21:03
 */
@Controller
@RequestMapping("instock")
public class IsStockController {

    @Reference
    private InstockService instockService;
    @Reference
    private StockInfoService stockInfoService;
    @Reference
    private MaterialsInfoService materialsInfoService;

    @Reference
    private SupplierInfoService supplierInfoService;
    @Reference
    private DataStatusService dataStatusService;

    @RequestMapping("toAddInstock")
    public String toAddInstock(Integer materialsId, ActualsStockVO actualsStockVO, Model model)
    {
        WZXMaterialsInfo wzxMaterialsInfo = materialsInfoService.queryMaterialsInfoByMaterialsId(materialsId);
        model.addAttribute("wzxMaterialsInfo",wzxMaterialsInfo);
        model.addAttribute("actualsStockvo",actualsStockVO);
        model.addAttribute("stockInfos",stockInfoService.queryAllStockInfo());
        model.addAttribute("suppliers",supplierInfoService.queryAllSupplierInfo());
        return "receptionroom/storageroom_addwarehousing";
    }

    @RequestMapping(value = "doAddInstock",method = RequestMethod.POST)
    public String doAddInstock(WZXInstock wzxInstock, Model model){
       /* Boolean aBoolean = materialsInfoService.queryMaterialsInfoBymaterialsBarCode(wzxMaterialsInfo.getMaterialsBarCode());
        Integer addInstock =null;
        if(aBoolean){
            addInstock=instockService.addInstock(wzxInstock);
        }else{
            materialsInfoService.addMaterialsInfo(wzxMaterialsInfo);
            wzxInstock.setMaterialsId(wzxMaterialsInfo.getMaterialsId());
            addInstock=instockService.addInstock(wzxInstock);
        }*/
        Integer addInstock=instockService.addInstock(wzxInstock);
        Integer updateMaterialsInfo=materialsInfoService.UpdateMaterialsInfoByMaterialsId(wzxInstock);
        if(addInstock!=null){
            model.addAttribute("msg","添加出库单成功");
           return "forward:/actuals/queryAll";
        }else{
            model.addAttribute("msg","添加出库单失败");
            return "forward:/actuals/queryAll";
        }
    }

    @RequestMapping("amountConversion")
    @ResponseBody
    public JSONObject  amountConversion(String num){
        JSONObject json=new JSONObject();
        String cnMoneyUnit = MyDigitUtils.number2CNMoneyUnit(Integer.parseInt(num));
        json.put("data",cnMoneyUnit);
        System.out.println("cnMoneyUnit:"+cnMoneyUnit);
        return json;
    }

    @RequestMapping("toWarehousing")
    public String toWarehousing(){
        return "/receptionroom/storageroom_warehousing";
    }

    @RequestMapping("queryInStockByInstockVO")
    public String queryInstock(InstockVO instockVO, Integer pageNo, Integer pageSize,Model model)
    {
        if(pageNo==null){
            pageNo=1;
        }
        if(pageSize==null){
            pageSize=5;
        }
        PageUtil<InstockVO> voPageUtil = instockService.queryAllInstockVOByInstock(instockVO, pageNo, pageSize);
        PageUtil<MaterialsInfoVO> materialsInfoVOPageUtil = materialsInfoService.queryAllMaterialsInfoVO(null, pageNo, pageSize);
        model.addAttribute("pageUtilsInstock",voPageUtil);
        model.addAttribute("materialsInfoVOPageUtil",materialsInfoVOPageUtil);
        return "/receptionroom/storageroom_lookwarehousing";
    }









}
