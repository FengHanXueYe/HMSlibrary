package cn.hotel.hms.controller;

import cn.hotel.entity.DataStatus;
import cn.hotel.service.DataStatusService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.DataStatusVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "dataStatus")
public class DataStatusController {

    @Reference
    private DataStatusService dataStatusService;


    //根据类型code查询
    @RequestMapping(value = "queryByCode",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryByCode(String code){
        List<DataStatus> dataStatuses = dataStatusService.queryByCode(code);
        return JSON.toJSONString(dataStatuses);
    }

    //给客房类型页面跳转查询使用
    @RequestMapping(value = "queryRoomType")
    public String queryByCodeA(DataStatus status,Integer pageNo,Integer pageSize,Model model){
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        PageUtil<DataStatusVO> pageUtil = dataStatusService.queryAll(status, pageNo, pageSize);
        for (int i : pageUtil.getNavigatepageNums()) {
            System.out.println(">>>>>>>>>>>>>>"+i);
        }

        model.addAttribute("pageUtil",pageUtil);
        model.addAttribute("status",status);
        return "room/room_type";
    }


    @RequestMapping(value = "toRoomTypeAdd")
    public String toRoomTypeAdd(){
        return "room/room_type_add";
    }

    @RequestMapping(value = "saveRoomType")
    @ResponseBody
    public String saveRoomType(DataStatus status){
        status.setCreatedBy(1);
        Integer save = dataStatusService.save(status);
        if(save != -1){
            return "ok";
        }

        return "error";

    }

    @RequestMapping(value = "queryById",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryById(Integer id){
        DataStatusVO dataStatusVO = dataStatusService.queryById(id);
        return JSON.toJSONString(dataStatusVO);
    }

    @RequestMapping(value = "updateRoomType",method = RequestMethod.POST)
    @ResponseBody
    public String updateRoomType(DataStatus dataStatus){
        dataStatus.setModifyBy(1);
        Integer update = dataStatusService.update(dataStatus);
        if(update != -1){
            return "ok";
        }

        return "error";
    }

    @RequestMapping(value = "delRoomTypeById",method = RequestMethod.POST)
    @ResponseBody
    public String delRoomTypeById(Integer id){
        Integer fag = dataStatusService.delById(id);
        if(fag != -1){
            return "ok";
        }

        return "error";
    }


}
