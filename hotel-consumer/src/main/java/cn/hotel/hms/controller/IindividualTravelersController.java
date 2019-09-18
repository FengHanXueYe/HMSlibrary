package cn.hotel.hms.controller;

import cn.hotel.entity.IindividualTravelers;
import cn.hotel.service.IindividualTravelersService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.IindividualTravelersVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 散客
 */
@Controller
public class IindividualTravelersController {

    @Reference
    private IindividualTravelersService iindividualTravelersService;

    // 去散了信息列表页面
    @RequestMapping(value = "toIindividualTravelers")
    public String toIindividualTravelers(){
        return "personnel/IindividualTravelers";
    }

    // ajax查询散客信息列表
    @ResponseBody
    @RequestMapping(value = "ajaxQueryAllIindividualTravelers", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxQueryAllIindividualTravelers(IindividualTravelers iindividualTravelers, Integer pageNum, Integer pageSize){
        PageUtil<IindividualTravelersVO> iindividualTravelersVOPageUtil = iindividualTravelersService.queryAllIindividualTravelersPage(iindividualTravelers, pageNum, pageSize);
        for (IindividualTravelersVO iindividualTravelersVO : iindividualTravelersVOPageUtil.getList()) {
            System.out.println(">>>--------"+iindividualTravelersVO);
        }
        return JSON.toJSONString(iindividualTravelersVOPageUtil);
    }

    // ajax 查询详情
    @ResponseBody
    @RequestMapping(value = "ajaxDetailIindividualTravelersVO", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String ajaxDetailIindividualTravelersVO(Integer itId){
        IindividualTravelers i = new IindividualTravelers();
        i.setItId(itId);
        IindividualTravelersVO iindividualTravelersVO = iindividualTravelersService.detailIindividualTravelers(i);
        return JSON.toJSONString(iindividualTravelersVO);
    }

    // ajax 编辑保存
    @ResponseBody
    @RequestMapping(value = "ajaxUpdateIindividualTravelers", method = RequestMethod.POST)
    public boolean ajaxUpdateIindividualTravelers(IindividualTravelers iindividualTravelers){
        Integer integer = iindividualTravelersService.updateIindividualTravelers(iindividualTravelers);
        return integer>0?true:false;
    }


    // 去增加页面
    @RequestMapping(value = "toInsertII")
    public String toInsertII(){
        return "personnel/insertIindividualTravelers";
    }

    // 增加操作
    @ResponseBody
    @RequestMapping(value = "doInsertII", method = RequestMethod.POST)
    public boolean doInsertII(IindividualTravelers iindividualTravelers){
        if(iindividualTravelers.getItRemarks()==""){
            iindividualTravelers.setItRemarks("无");
        }
        Integer integer = iindividualTravelersService.insertIindividualTravelers(iindividualTravelers);
        return integer>0?true:false;
    }

    // 删除
    @ResponseBody
    @RequestMapping(value = "ajaxDeleteII", method = RequestMethod.POST)
    public boolean ajaxDeleteII(Integer itId){
        Integer integer = iindividualTravelersService.deleteIindividualTravelers(itId);
        return integer>0?true:false;
    }




}
