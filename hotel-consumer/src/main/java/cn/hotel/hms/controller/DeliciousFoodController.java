package cn.hotel.hms.controller;

import cn.hotel.entity.DeliciousFood;
import cn.hotel.hms.Util.FileUtil;
import cn.hotel.service.DeliciousFoodService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.DeliciousFoodVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

import static cn.hotel.hms.Util.FileUtil.getFileName;

@Controller
public class DeliciousFoodController {
    @Reference
    private DeliciousFoodService deliciousFoodService;

    @Value("${imgage}")
    private String logPath;

    @Autowired
    private FileUtil fileUtil;


    @RequestMapping(value = "queryAllFood")
    public String toIndex(){
        return "food/food_list";
    }

    @ResponseBody
    @RequestMapping(value = "queryAllDelicious", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String queryAllDelicious(DeliciousFood deliciousFood, Integer pageNum, Integer pageSize){
        if (pageNum==-1){
            pageNum = null;
        }
        PageUtil<DeliciousFoodVo> deliciousFoodVoPageUtil=this.deliciousFoodService.queryAllFood(deliciousFood,pageNum,pageSize);
        System.out.println(deliciousFoodVoPageUtil.getNavigatepageNums());
        for (DeliciousFoodVo food : deliciousFoodVoPageUtil.getList()) {
            System.out.println(""+food);
        }
        return JSON.toJSONString(deliciousFoodVoPageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "DetailDelicious", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String detailDelicious(Integer id){
        DeliciousFoodVo deliciousFoodVo=deliciousFoodService.detailDeliciousFood(id);
        return JSON.toJSONString(deliciousFoodVo);
    }


    @ResponseBody
    @RequestMapping(value = "DeleteDelicious", method = RequestMethod.POST)
    public boolean deleteDelicious(Integer id){
        Integer delicious=deliciousFoodService.deleteDeliciousFood(id);
        return delicious>0?true:false;
    }


    @RequestMapping(value = "toAddDelicious")
    public String toAddDelicious(){
        return "food/add_food";
    }

    @RequestMapping(value = "doAddDelicious",method = RequestMethod.POST)
    public String doAddDelicious(MultipartFile file,DeliciousFood deliciousFood,BindingResult result){
        System.out.println(">>>"+file);
        String fillName=fileUtil.upload(file,1);
        deliciousFood.setFoodimgone(logPath+fillName);
        this.deliciousFoodService.addDeliciousFood(deliciousFood);
        return "redirect:queryAllFood";
    }


    private String path="images";//要保存的文件夹的名字,需修改
    @RequestMapping(value="fileController",produces = "text/html;charset=UTF-8")//解决返回中文乱码
    @ResponseBody//设置ajax 返回保存路径
    public String fileController(MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        //寻找要保存的文件夹(保存路径)
        String savePath = request.getSession().getServletContext().getRealPath("/"+path+"/");
        try {
            file.transferTo(new File(savePath+"/"+file.getOriginalFilename()));
            //在"/"后面可以自行拼接name或加入随机数(以免不同用户上传替换)
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/"+path+"/"+file.getOriginalFilename();
    }
    @RequestMapping(value = "toUpdateDelicious")
    public String toUpdateDelicious(Integer id, Model model){
        model.addAttribute("delicious",this.deliciousFoodService.detaDeliciousFood(id));
        return "food/delicious_update";
    }

    @RequestMapping(value = "doUpdateDelicious",method = RequestMethod.POST)
    public String doUpdateDelicious(MultipartFile file,DeliciousFood deliciousFood,BindingResult result){
        String fillName=fileUtil.upload(file,1);
        deliciousFood.setFoodimgone(logPath+fillName);
        this.deliciousFoodService.updateDeliciousFood(deliciousFood);
        System.out.println("--------------------------------7---------------------------------"+this.deliciousFoodService.updateDeliciousFood(deliciousFood));
        return "redirect:queryAllFood";
    }

}
