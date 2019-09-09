package cn.hotel.hms.controller;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.WZXActualStock;
import cn.hotel.service.ActualsStockVoService;
import cn.hotel.service.DataStatusService;
import cn.hotel.service.MaterialsLocationService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.ActualsStockVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-06 11:00
 */
@Controller
@RequestMapping("actuals")
public class ActualsStockController {

    @Reference
    private ActualsStockVoService actualsStockVoService;

    @Reference
    private MaterialsLocationService materialsLocationService;

    @Reference
    private DataStatusService dataStatusService;

    /**
     * 查询实际库存
     * @param actualsStockVO  根据库房、货品名称、是否停用、条形码、货物警报查询
     * @param pageNo   当前页
     * @param pageSize 当前页数据数量
     * @param model
     * @return   storageroom_list:实际库存管理页面
     */
    @RequestMapping("queryAll")
    public String  queryAll(ActualsStockVO actualsStockVO, Integer pageNo, Integer pageSize, Model model){
        PageUtil<ActualsStockVO> actualsStockVOPageUtil = actualsStockVoService.queryAll(actualsStockVO, pageNo, pageSize);
        List<ActualsStockVO> list=new ArrayList<>();
        model.addAttribute("actualsStockVOPageUtil",actualsStockVOPageUtil);
        for (ActualsStockVO stockVO : actualsStockVOPageUtil.getList()) {
            List<DataStatus> dataStatuses = dataStatusService.queryByCode(stockVO.getMaterialsInfo().getTypeCode());
            stockVO.setStatusList(dataStatuses);
            list.add(stockVO);
        }
        model.addAttribute("list",list);
        return "receptionroom/storageroom_list";
    }

    /**
     * 跳到前台页面
     * @return
     */
    @RequestMapping("toreception")
    public String toreception(){
        return "receptionroom/reception";
    }

    @RequestMapping("delActualsStock")
    @ResponseBody
    public JSONObject delActualsStock(Integer asNumber){
        JSONObject jsonObject=new JSONObject();
        WZXActualStock actualStock = actualsStockVoService.queryActualStockByasNumber(asNumber);
        Integer stockByasNumber = actualsStockVoService.delActualStockByasNumber(asNumber);
        Integer delLocation=materialsLocationService.delMaterialsLocation(actualStock.getGoodsLocationNumber());
        if(stockByasNumber>0){
            jsonObject.put("msg","删除成功");
            jsonObject.put("data","");
            jsonObject.put("code",0);
            return jsonObject;
        }
        jsonObject.put("msg","删除失败");
        jsonObject.put("data","");
        jsonObject.put("code",1);
        return jsonObject;
    }
}
