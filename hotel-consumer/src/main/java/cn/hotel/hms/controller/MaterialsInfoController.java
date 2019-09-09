package cn.hotel.hms.controller;

import cn.hotel.entity.WZXMaterialsInfo;
import cn.hotel.service.MaterialsInfoService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.MaterialsInfoVO;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 20:16
 */
@RequestMapping("materials")
public class MaterialsInfoController {


    @Reference
    private MaterialsInfoService materialsInfoService;

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
}
