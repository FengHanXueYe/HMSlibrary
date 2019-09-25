package cn.hotel.hms.controller;

import cn.hotel.dto.Img;
import cn.hotel.dto.UploadResponseData;
import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.entity.DataStatus;
import cn.hotel.entity.Operator;
import cn.hotel.entity.Room;
import cn.hotel.service.ConsumptionRecordService;
import cn.hotel.service.DataStatusService;
import cn.hotel.service.OperatorService;
import cn.hotel.service.RoomService;
import cn.hotel.vo.OperatorVO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-17 15:11
 */
@Controller
@RequestMapping("common")
public class CommonController {

    @Reference
    private OperatorService operatorService;

    @Reference
    private RoomService roomService;

    @Reference
    private ConsumptionRecordService consumptionRecordService;

    @Reference
    private DataStatusService dataStatusService;

    //fileinput 其实每次只会上传一个文件  多图上传也是分多次请求,每次上传一个文件 所以不需要循环
    //@RequestParam("images") 这里的images对应表单中name 然后MultipartFile 参数名就可以任意了
    @RequestMapping(value = "/image/save-test",method = RequestMethod.POST)
    @ResponseBody
    public UploadResponseData saveImg(@RequestParam("images") MultipartFile file) throws IOException {
        String pathname = "";
        String returnPath = "";
        if (!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            File path = new File(ResourceUtils.getURL("classpath:").getPath());//获取Spring boot项目的根路径，在开发时获取到的是/target/classes/
            System.out.println(path.getPath());//如果你的图片存储路径在static下，可以参考下面的写法
            File uploadFile = new File(path.getAbsolutePath(), "static/images/upload/");//开发测试模式中 获取到的是/target/classes/static/images/upload/
            if (!uploadFile.exists()){
                uploadFile.mkdirs();
            }
            //获取文件后缀名
            String end = FilenameUtils.getExtension(file.getOriginalFilename());
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            //图片名称 采取时间拼接随机数
            String name = df.format(new Date());
            Random r = new Random();
            for(int i = 0 ;i < 3 ;i++){
                name += r.nextInt(10);
            }
            String diskFileName = name + "." +end; //目标文件的文件名
            pathname = uploadFile.getPath()+ "/" + diskFileName;
            System.out.println(pathname);
            returnPath = "images/upload/" + diskFileName;//这里是我自己做返回的字符串

            file.transferTo(new File(pathname));//文件转存
        }//UploadResponseData 自定义返回数据类型实体{int code, String msg, Object data}
        return new UploadResponseData(0,"上传成功",new Img(returnPath,new Date()));
    }

    @RequestMapping("todemoTwo")
    public String todemoTwo(){
        return "/receptionroom/demoTwo";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "/testHtml/login";
    }

    @RequestMapping("doLogin")
    public String doLogin(Operator operator, Model model)
    {
        OperatorVO operatorVO = operatorService.loginUser(operator);
        if(operatorVO!=null){
            List<Room> rooms = roomService.queryRoomAllNumber();

            Room room=null;
            //闲置客房
            Integer roomNum=0;
            for (int i = 0; i <rooms.size() ; i++) {
                    roomNum+=1;
            }

            //查询当日营业额、当日入住人数
            ConsumptionRecord consumptionRecord = consumptionRecordService.queryConsumptionRecordCount();
            model.addAttribute("consumptionRecord",consumptionRecord);

            model.addAttribute("roomNum",roomNum);
            model.addAttribute("User",operatorVO);

            return "/receptionroom/reception";
        }

        return "/testHtml/login";
    }

    @RequestMapping("toHome")
    public String toHome(Model model){
        //已预约客房
        List<Room> roomListYu=roomService.queryRoomAllMake();
        //客房状态
        List<DataStatus> room_status = dataStatusService.queryByCode("ROMM_TYPE");

        model.addAttribute("roomListYu",roomListYu);
        model.addAttribute("room_status",room_status);
        return "index";
    }
}
