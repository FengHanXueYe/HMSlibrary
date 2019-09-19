package cn.hotel.hms.controller;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.entity.WZXSupplierInfo;
import cn.hotel.service.*;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MaterialsInfoVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 20:16
 */
@RequestMapping("materials")
@Controller
public class MaterialsInfoController {


    @Reference
    private MaterialsInfoService materialsInfoService;

    @Reference
    private InstockService instockService;

    @Reference
    private SupplierInfoService supplierInfoService;

    @Reference
    private StockInfoService stockInfoService;

    @Reference
    private DataStatusService dataStatusService;
    @RequestMapping("queryMaterialsInfos")
    public String queryMaterialsInfo(WZXMaterialsInfo materialsInfo, Integer pageNo, Integer pageSize, Model model){
        if(pageNo==null){
            pageNo=1;
        }
        if(pageSize==null){
            pageSize=10;
        }

        PageUtil<MaterialsInfoVO> materialsInfoVOPageUtil = materialsInfoService.queryAllMaterialsInfoVO(materialsInfo, pageNo, pageSize);
        model.addAttribute("materialsInfoVOPageUtil",materialsInfoVOPageUtil);
        return "/receptionroom/storageroom_lookwarehousing";
    }

    @RequestMapping("queryMaterialsInfoAll")
    public String queryMaterialsInfoAll(WZXMaterialsInfo materialsInfo, Integer pageNo, Integer pageSize, Model model){
        if(pageNo==null){
            pageNo=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        List<MaterialsInfoVO>  list=new ArrayList<>();
        PageUtil<MaterialsInfoVO> materialsInfoVOPageUtil = materialsInfoService.queryAllMaterialsInfoVO(materialsInfo, pageNo, pageSize);

        //查询所有分类
        for (MaterialsInfoVO materialsInfoVO : materialsInfoVOPageUtil.getList()) {
            List<DataStatus> dataStatuses = dataStatusService.queryByCode(materialsInfoVO.getTypeCode());
            materialsInfoVO.setStatusList(dataStatuses);
            list.add(materialsInfoVO);
        }
        model.addAttribute("materialsInfoVOPageUtil",materialsInfoVOPageUtil);
        model.addAttribute("list",list);
        return "/receptionroom/storageroom_goods";
    }
    @RequestMapping(value = "queryMaterialsByInfo",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryInstock(WZXMaterialsInfo wzxMaterialsInfo, Integer pageNo, Integer pageSize)
    {
        if(pageNo==null){
            pageNo=1;
        }
        if(pageSize==null){
            pageSize=5;
        }
        //查询所有物品信息、用于入库操作的模态框
        PageUtil<MaterialsInfoVO> materialsInfoVOPageUtil = materialsInfoService.queryAllMaterialsInfoVO(wzxMaterialsInfo, pageNo, 10);
        return JSONObject.toJSONString(materialsInfoVOPageUtil.getList());
    }

    @RequestMapping(value = "delMaterialsInfo",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject  delInstock(Integer materialsId){
        JSONObject json=new JSONObject();
        Integer delInstock =null;
        try {
            delInstock = materialsInfoService.delMaterialsInfo(materialsId);
        } catch (Exception e) {
            json.put("code",1);
            json.put("msg","系统出现错误");
            json.put("data","");
            e.printStackTrace();
            return json;
        }

        if(delInstock!=null ||delInstock>0){
            json.put("code",0);
            json.put("msg","删除成功");
            json.put("data","");
        }else{
            json.put("code",1);
            json.put("msg","删除失败");
            json.put("data","");
        }
        return json;
    }

    @RequestMapping("toUpdateMaterialsInfo")
    public String toUpdateMaterialsInfo(Integer materialsId,Model model){
        MaterialsInfoVO materialsInfoVO=new MaterialsInfoVO();
        //查询物品信息
        WZXMaterialsInfo materialsInfo = materialsInfoService.queryMaterialsInfoByMaterialsId(materialsId);
        //查询分类信息
        List<DataStatus> dataStatuses = dataStatusService.queryByCode(materialsInfo.getTypeCode());
        materialsInfoVO.setStatusList(dataStatuses);
        //查询供应商
        List<WZXSupplierInfo> supplierInfos = supplierInfoService.queryAllSupplierInfo();

        model.addAttribute("supplierInfos",supplierInfos);
        model.addAttribute("materialsInfoVO",materialsInfoVO);
        model.addAttribute("materialsInfo",materialsInfo);
        return "/receptionroom/storageroom_updateMaterials";
    }
    @RequestMapping(value = "doUpdateMaterialsInfo",method = RequestMethod.POST)
    public String doUpdateMaterialsInfo(WZXMaterialsInfo wzxMaterialsInfo,Model model){
        Integer materialsInfo = materialsInfoService.updateMaterialsInfo(wzxMaterialsInfo);
        if(materialsInfo>0){
            model.addAttribute("修改成功");

            return "redirect:/materials/queryMaterialsInfoAll";
        }else{
            model.addAttribute("修改失败");
            return "forward:/materials/toUpdateMaterialsInfo?materialsId="+wzxMaterialsInfo.getMaterialsId();
        }
    }

    @RequestMapping("queryDetailMaterialsInfo")
    public String queryDetailMaterialsInfo(Integer materialsId,Model model){
        MaterialsInfoVO materialsInfoVO=new MaterialsInfoVO();
        //查询物品信息
        WZXMaterialsInfo materialsInfo = materialsInfoService.queryMaterialsInfoByMaterialsId(materialsId);
        //查询分类信息
        List<DataStatus> dataStatuses = dataStatusService.queryByCode(materialsInfo.getTypeCode());
        materialsInfoVO.setStatusList(dataStatuses);
        //查询供应商
        List<WZXSupplierInfo> supplierInfos = supplierInfoService.queryAllSupplierInfo();

        model.addAttribute("supplierInfos",supplierInfos);
        model.addAttribute("materialsInfoVO",materialsInfoVO);
        model.addAttribute("materialsInfo",materialsInfo);
        return "/receptionroom/storageroom_detailMaterialsInfo";
    }

    @RequestMapping("toAddMaterialsInfo")
    public String toAddMaterialsInfo(Model model){
        //查询物品信息
        //查询分类信息
        List<DataStatus> dataStatuses = dataStatusService.queryByCode("MATERIALS_TYPE");
        //查询供应商
        List<WZXSupplierInfo> supplierInfos = supplierInfoService.queryAllSupplierInfo();

        model.addAttribute("dataStatuses",dataStatuses);
        model.addAttribute("supplierInfos",supplierInfos);
        return "/receptionroom/storageroom_addMaterialsInfo";
    }

    @RequestMapping(value = "doAddMaterialsInfo",method = RequestMethod.POST)
    public String doAddMaterialsInfo(WZXMaterialsInfo wzxMaterialsInfo,Model model){
        System.out.println("MaterialsStartDate:"+wzxMaterialsInfo.getMaterialsStartDate());
        Integer materialsInfo = materialsInfoService.addMaterialsInfo(wzxMaterialsInfo);
        if(materialsInfo>0){
            return "redirect:/materials/queryMaterialsInfoAll";
        }else{
            return "redirect:/materials/toAddMaterialsInfo";
        }
    }
}
