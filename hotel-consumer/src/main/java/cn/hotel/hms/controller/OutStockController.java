package cn.hotel.hms.controller;

import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXOutStock;
import cn.hotel.entity.WZXStockInfo;
import cn.hotel.service.MaterialsInfoService;
import cn.hotel.service.OutStockService;
import cn.hotel.service.StockInfoService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.OutStockVO;
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
        return "storageroom_addoutstock";
    }

    @RequestMapping(value = "doAddOutStock",method = RequestMethod.POST)
    public String doAddOutStock(WZXOutStock wzxOutStock,Model model){
        Integer outStock = outStockService.addOutStock(wzxOutStock);
        if(outStock>0){
            return "redirect:/actuals/queryAll";
        }else{
            return "storageroom_addoutstock";
        }
    }

    @RequestMapping("toOutstockList")
    public String toOutstockList(){
        return "/receptionroom/storageroom_outstocklist";
    }

    @RequestMapping("queryAllOutStockVO")
    public String queryAllOutStockVO(OutStockVO outStockVO,Integer pageNum,Integer pageSize,Model model){
        //查询所有入库单信息
        PageUtil<OutStockVO> pageUtil = outStockService.queryAllOutStockVO(outStockVO, pageNum, pageSize);
        //查询所有仓库信息
        List<WZXStockInfo> stockInfos = stockInfoService.queryAllStockInfo();
        model.addAttribute("stockInfos",stockInfos );
        model.addAttribute("pageUtil",pageUtil);
        return "/receptionroom/storageroom_outstocklist";
    }

    @RequestMapping("toUpdateOutStockVO")
    public String toUpdateOutStockVO(Integer osId,Model model){
        OutStockVO outStockVO = outStockService.queryAllOutStockVOByOsId(osId);
        //查询所有仓库信息
        List<WZXStockInfo> stockInfos = stockInfoService.queryAllStockInfo();
        model.addAttribute("stockInfos",stockInfos );
        model.addAttribute("outStockVO",outStockVO);
        return "/receptionroom/storageroom_updateOutStock";
    }
    @RequestMapping("toDetailOutStockVO")
    public String toDetailOutStockVO(Integer osId,Model model){
        OutStockVO outStockVO = outStockService.queryAllOutStockVOByOsId(osId);
        //查询所有仓库信息
        List<WZXStockInfo> stockInfos = stockInfoService.queryAllStockInfo();
        model.addAttribute("stockInfos",stockInfos );
        model.addAttribute("outStockVO",outStockVO);
        return "/receptionroom/storageroom_detailOutStock";
    }

    @RequestMapping("doUpdateOutStockVO")
    public String doUpdateOutStock(WZXOutStock wzxOutStock,Model model){
        Integer updateOutStock = outStockService.updateOutStock(wzxOutStock);
        if(updateOutStock>0){
            model.addAttribute("msg","修改成功");
            return this.queryAllOutStockVO(null,null,null,model);
        }else{
            return "redirect:/outStock/toUpdateOutStockVO?osId="+wzxOutStock.getOsId();
        }
    }

    @RequestMapping(value = "delOutStock",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject  delOutStock(Integer osId){
        JSONObject json=new JSONObject();
        Integer stock = null;
        try {
            stock = outStockService.delOutStock(osId);
        } catch (Exception e) {
            json.put("msg","系统出现错误，正在修复中！");
            json.put("code",1);
            json.put("data","");
            e.printStackTrace();
            return json;
        }
        if(stock>0){
            json.put("msg","删除成功");
            json.put("code",0);
            json.put("data","");
        }else{
            json.put("msg","删除失败");
            json.put("code",1);
            json.put("data","");
        }
        return json;
    }
}
