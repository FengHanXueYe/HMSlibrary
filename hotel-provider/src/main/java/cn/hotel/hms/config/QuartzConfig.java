package cn.hotel.hms.config;


import cn.hotel.entity.MemberShipScore;
import cn.hotel.service.MemberShipScoreService;
import cn.hotel.vo.MemberShipScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

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
//    @Scheduled(cron = "*/2 * * * * *")
    @Scheduled(cron = "0 15 10 * * ?")
    public void sysText(){
        List<MemberShipScoreVO> memberShipScoreVOS = memberShipScoreService.ListdetailMSSV(6);
        if(memberShipScoreVOS.size()>1){
            for (MemberShipScoreVO memberShipScoreVO : memberShipScoreVOS) {
                MemberShipScore memberShipScore = new MemberShipScore();
                memberShipScore.setMssStatus(1);
                memberShipScore.setMssId(memberShipScoreVO.getMssId());
                memberShipScoreService.updateMemberShipScore(memberShipScore);
            }
        }else{
            // 获取昨天的幸运会员
            MemberShipScoreVO memberShipScoreVO1 = memberShipScoreService.detailMSSV(6);
            if(null!=memberShipScoreVO1){
                // 修改状态
                MemberShipScore memberShipScore = new MemberShipScore();
                memberShipScore.setMssId(memberShipScoreVO1.getMssId());
                memberShipScore.setMssStatus(1);
                memberShipScoreService.updateMemberShipScore(memberShipScore);
            }
        }

        // 生成今天的幸运会员
        MemberShipScoreVO memberShipScoreVO = memberShipScoreService.detailMemberShipScoreVO();
        MemberShipScore memberShipScore = new MemberShipScore();
        memberShipScore.setMssId(memberShipScoreVO.getMssId());
        memberShipScore.setMssStatus(6);
        System.out.println("今日会员===》》》"+memberShipScoreVO);
        Integer a = memberShipScoreService.updateMemberShipScore(memberShipScore);
    }

}
