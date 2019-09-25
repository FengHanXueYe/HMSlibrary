package cn.hotel.hms.controller;

import cn.hotel.entity.*;
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

import java.util.List;

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
    private MaterialsLocationService materialsLocationService;
    @Reference
    private ActualsStockVoService actualsStockservice;
    @Reference
    private SupplierInfoService supplierInfoService;
    @Reference
    private DataStatusService dataStatusService;

    @RequestMapping("toAddInstock")
    public String toAddInstock(Integer materialsId, ActualsStockVO actualsStockVO, Model model) {
        WZXMaterialsInfo wzxMaterialsInfo = materialsInfoService.queryMaterialsInfoByMaterialsId(materialsId);
        System.out.println("actualsStockVO:"+actualsStockVO);
        model.addAttribute("wzxMaterialsInfo", wzxMaterialsInfo);
        model.addAttribute("actualsStockvo", actualsStockVO);
        model.addAttribute("stockInfos", stockInfoService.queryAllStockInfo());
        model.addAttribute("suppliers", supplierInfoService.queryAllSupplierInfo());
        return "receptionroom/storageroom_addwarehousing";
    }

    @RequestMapping(value = "doAddInstock", method = RequestMethod.POST)
    public String doAddInstock(WZXInstock wzxInstock, Model model) {
       /* Boolean aBoolean = materialsInfoService.queryMaterialsInfoBymaterialsBarCode(wzxMaterialsInfo.getMaterialsBarCode());
        Integer addInstock =null;
        if(aBoolean){
            addInstock=instockService.addInstock(wzxInstock);
        }else{
            materialsInfoService.addMaterialsInfo(wzxMaterialsInfo);
            wzxInstock.setMaterialsId(wzxMaterialsInfo.getMaterialsId());
            addInstock=instockService.addInstock(wzxInstock);
        }*/
        Integer addInstock = instockService.addInstock(wzxInstock);
        Integer updateMaterialsInfo = materialsInfoService.UpdateMaterialsInfoByMaterialsId(wzxInstock);
        if (addInstock != null) {
            model.addAttribute("msg", "添加出库单成功");
            return "forward:/actuals/queryAll";
        } else {
            model.addAttribute("msg", "添加出库单失败");
            return "forward:/actuals/queryAll";
        }
    }

    @RequestMapping("amountConversion")
    @ResponseBody
    public JSONObject amountConversion(String num) {
        JSONObject json = new JSONObject();
        String cnMoneyUnit = MyDigitUtils.number2CNMoneyUnit(Integer.parseInt(num));
        json.put("data", cnMoneyUnit);
        return json;
    }

    @RequestMapping("toWarehousing")
    public String toWarehousing() {
        return "/receptionroom/storageroom_warehousing";
    }

    @RequestMapping("queryInStockByInstockVO")
    public String queryInstock(InstockVO instockVO, Integer pageNo, Integer pageSize, Model model) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }

        //查询所有入库单信息
        PageUtil<InstockVO> voPageUtil = instockService.queryAllInstockVOByInstock(instockVO, pageNo, pageSize);
        //查询所有物品信息、用于入库操作的模态框
        PageUtil<MaterialsInfoVO> materialsInfoVOPageUtil = materialsInfoService.queryAllMaterialsInfoVO(null, pageNo, pageSize);
        //查询所有库房
        List<WZXStockInfo> stockInfos = stockInfoService.queryAllStockInfo();
        //查询所有供应商
        List<WZXSupplierInfo> supplierInfos = supplierInfoService.queryAllSupplierInfo();
        model.addAttribute("pageUtilsInstock", voPageUtil);
        model.addAttribute("materialsInfoVOPageUtil", materialsInfoVOPageUtil);
        model.addAttribute("stockInfos", stockInfos);
        model.addAttribute("supplierInfos", supplierInfos);
        model.addAttribute("pageUtilsInstockJson",JSONObject.toJSONString(voPageUtil));
        return "/receptionroom/storageroom_warehousing";
    }


    @RequestMapping("toAddInstockTwo")
    public String toAddInstockTwo(Integer materialsId, String materialsNumber, Model model) {
        WZXMaterialsInfo wzxMaterialsInfo = materialsInfoService.queryMaterialsInfoByMaterialsId(materialsId);
        WZXActualStock actualsStockVO = actualsStockservice.queryActualsStockBymaterialsNumber(materialsId.toString());
        if (actualsStockVO == null) {
            model.addAttribute("wzxMaterialsInfo", wzxMaterialsInfo);
            model.addAttribute("stockInfos", stockInfoService.queryAllStockInfo());
            model.addAttribute("suppliers", supplierInfoService.queryAllSupplierInfo());
            return "receptionroom/storageroom_twoAddwarehousing";
        }
        model.addAttribute("wzxMaterialsInfo", wzxMaterialsInfo);
        model.addAttribute("actualsStockvo", actualsStockVO);
        model.addAttribute("stockInfos", stockInfoService.queryAllStockInfo());
        model.addAttribute("suppliers", supplierInfoService.queryAllSupplierInfo());
        return "receptionroom/storageroom_addwarehousing";
    }

    @RequestMapping(value = "doAddIsStockTwo", method = RequestMethod.POST)
    public String doAddIsStockTwo(WZXMaterialsLocation wzxMaterialsLocation, ActualsStockVO actualsStockVO, WZXInstock wzxInstock, Model model) {
        WZXActualStock actualStock = new WZXActualStock();
        actualStock.setStockNumber(actualsStockVO.getStockInfo().getStockId().toString());

        //货位实体获取仓库id
        wzxInstock.setStockNumber(actualsStockVO.getStockInfo().getStockId().toString());
        //添加出库单
        Integer addInstock = instockService.addInstock(wzxInstock);
        //添加实际库存货位
        wzxMaterialsLocation.setStockNumber(actualsStockVO.getStockInfo().getStockId());
        actualStock.setMaterialsId(wzxInstock.getMaterialsId().toString());
        actualStock.setMaterialss(0);
        //添加实际库存
        Integer addActualsStockVO = actualsStockservice.addActualStock(actualStock, wzxMaterialsLocation);
        if (addInstock != null) {
            model.addAttribute("msg", "添加出库单成功");
            return "forward:/actuals/queryAll";
        } else {
            model.addAttribute("msg", "添加出库单失败");
            return "forward:/actuals/queryAll";
        }

    }

    @RequestMapping("toUpdateInstcok")
    public String toUpdateInstcok(Integer isId, Model model) {
        //入库单详细信息
        InstockVO instockVO = instockService.queryAllInstockVoByIsId(isId);
        //仓库信息
        List<WZXStockInfo> stockInfos = stockInfoService.queryAllStockInfo();
        model.addAttribute("Instock", instockVO);
        model.addAttribute("stockInfos", stockInfos);
        return "/receptionroom/storageroom_updateInstock";
    }

    @RequestMapping("doUpdateInstock")
    public String doUpdateInstock(WZXInstock wzxInstock, Model model) {
        Integer instock = instockService.updateInstock(wzxInstock);
        if (instock > 0) {

            return "redirect:/instock/queryInStockByInstockVO";

        }
        model.addAttribute("msg", "修改失败");
        return this.toUpdateInstcok(wzxInstock.getIsId(), model);
    }


    @RequestMapping(value = "delInstock", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject delInstock(Integer isId) {
        JSONObject json = new JSONObject();
        Integer delInstock = null;
        try {
            delInstock = instockService.delInstock(isId);
        } catch (Exception e) {
            json.put("code", 1);
            json.put("msg", "系统出现错误");
            json.put("data", "");
            e.printStackTrace();
            return json;
        }

        if (delInstock != null || delInstock > 0) {
            json.put("code", 0);
            json.put("msg", "删除成功");
            json.put("data", "");
        } else {
            json.put("code", 1);
            json.put("msg", "删除失败");
            json.put("data", "");
        }
        return json;
    }

    @RequestMapping("toInstockDetail")
    public String toInstockDetail(Integer isId, Model model) {
        //入库单详细信息
        InstockVO instockVO = instockService.queryAllInstockVoByIsId(isId);
        //仓库信息
        List<WZXStockInfo> stockInfos = stockInfoService.queryAllStockInfo();
        model.addAttribute("stockInfos", stockInfos);
        model.addAttribute("Instock", instockVO);
        return "/receptionroom/storageroom_instock";
    }



}
