package cn.hotel.hms.config;


import cn.hotel.service.OperatorService;
import cn.hotel.vo.OperatorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class QuartzConfig {

//    @Reference
//    private MemberShipScoreService memberShipScoreService;
   // ApplicationContextUtil applicationContextUtil = ApplicationContextUtil.getBean("MemberShipScoreService");

    @Autowired
    private OperatorService operatorService;
    //private static final Logger log = Logger.getLogger(QuartzConfig.class);
        /**
         *  任务：
         *      向控制台输出内容
         */
    @Scheduled(cron = "*/2 * * * * *")
    public void sysText(){
        OperatorVO operatorVO = operatorService.detailOperator(1);
        System.out.println(operatorVO);
        System.out.println("============sdfasdfas=================");
        System.out.println(operatorService);
//        MemberShipScoreVO memberShipScoreVO = memberShipScoreService.detailMemberShipScoreVO();
//        System.out.println(memberShipScoreVO);
    }

}
