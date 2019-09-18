package cn.hotel.hms.config;


import cn.hotel.entity.MemberShipScore;
import cn.hotel.service.MemberShipScoreService;
import cn.hotel.vo.MemberShipScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class QuartzConfig {

    @Autowired
    private MemberShipScoreService memberShipScoreService;

    //private static final Logger log = Logger.getLogger(QuartzConfig.class);
        /**
         *  任务：
         *      向控制台输出内容
         */
    @Scheduled(cron = "*/2 * * * * *")
    public void sysText(){
        // 获取昨天的幸运会员
        MemberShipScoreVO memberShipScoreVO1 = memberShipScoreService.detailMSSV(6);
        if(null!=memberShipScoreVO1){
            // 修改状态
            MemberShipScore memberShipScore = new MemberShipScore();
            memberShipScore.setMssId(memberShipScoreVO1.getMssId());
            System.out.println("------->"+memberShipScore);
            memberShipScoreService.updateMemberShipScore(memberShipScore);
        }
        // 生成今天的幸运会员
        MemberShipScoreVO memberShipScoreVO = memberShipScoreService.detailMemberShipScoreVO();
        MemberShipScore memberShipScore = new MemberShipScore();
        memberShipScore.setMssId(memberShipScoreVO.getMssId());
        memberShipScore.setMssStatus(6);
        Integer a = memberShipScoreService.updateMemberShipScore(memberShipScore);
    }

}
