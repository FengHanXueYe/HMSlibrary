package cn.hotel.hms.controller;

import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXOutStock;
import cn.hotel.entity.WZXStockInfo;
import cn.hotel.service.MaterialsInfoService;
import cn.hotel.service.OutStockService;
import cn.hotel.service.StockInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 13:29
 */
@Controller
@RequestMapping("outStock")
public class OutStockController {

    @Reference
    private OutStockService outStockService;

    @Reference
    private MaterialsInfoService materialsInfoService;

    @Reference
    private StockInfoService stockInfoService;

    @RequestMapping("toAddOutStock")
    public String  toAddOutStock(Integer materialsId ,Integer stockId, Model model){
        /**
         * 查询所有仓库
         */
        List<WZXStockInfo> wzxStockInfos = stockInfoService.queryAllStockInfo();
        /**
         * 查询实际库存中物品的详细信息：名称等
         */
        WZXMaterialsInfo info = materialsInfoService.queryMaterialsInfoByMaterialsId(materialsId);
        model.addAttribute("StockInfo",wzxStockInfos);
        model.addAttribute("Materials",info);
        model.addAttribute("actualStock",stockId);
        return "receptionroom/storageromm_addoutstock";
    }

    @RequestMapping(value = "doAddOutStock",method = RequestMethod.POST)
    public String doAddOutStock(WZXOutStock wzxOutStock,Model model){
        Integer outStock = outStockService.addOutStock(wzxOutStock);
        Integer info = materialsInfoService.UpdatedelMaterialsInfoByMaterialsId(wzxOutStock);
        if(outStock>0){
            return "redirect:/actuals/queryAll";
        }else{
            return "receptionroom/storageromm_addoutstock";
        }
    }

    @RequestMapping("toOutstockList")
    public String toOutstockList(){
        return "/receptionroom/storageroom_outstocklist";
    }
}
