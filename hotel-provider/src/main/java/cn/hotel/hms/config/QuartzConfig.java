package cn.hotel.hms.config;


import cn.hotel.entity.MemberShipScore;
import cn.hotel.entity.Room;
import cn.hotel.entity.ToDayWardRound;
import cn.hotel.entity.WardRound;
import cn.hotel.service.MemberShipScoreService;
import cn.hotel.service.RoomService;
import cn.hotel.service.ToDayWardRoundService;
import cn.hotel.service.WardRoundService;
import cn.hotel.vo.MemberShipScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

import cn.hotel.service.OperatorService;
import cn.hotel.vo.OperatorVO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class QuartzConfig {

    @Autowired
    private MemberShipScoreService memberShipScoreService;

    @Autowired
    private ToDayWardRoundService toDayWardRoundService;

    @Autowired
    private WardRoundService wardRoundService;

    @Autowired
    private RoomService roomService;

    //private static final Logger log = Logger.getLogger(QuartzConfig.class);
        /**
         *  任务：
         *      向控制台输出内容
         */
//    @Scheduled(cron = "*/2 * * * * *")

    /**
     * 会员抽奖
      */
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

    /**
     * 每天查房
     *
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void wardRound(){
        // 清空今天的查房表
        Integer integer = toDayWardRoundService.truncateTable();
        // 将查房记录表中的今天状态修改
        WardRound wardRound = new WardRound();
        Integer integer1 = wardRoundService.updateWR(wardRound);
        // 查询所有空闲的房间
        List<Room> rooms = roomService.queryRoomAllNumber();
        // 将所有空闲的房间加到今天查房表中
        for (Room room : rooms) {
            ToDayWardRound toDayWardRound = new ToDayWardRound();
            toDayWardRound.setTdwrRoomNumber(room.getRoomNumber());
            toDayWardRound.setTdwrOId(1);
            toDayWardRoundService.insertToDayWardRound(toDayWardRound);
        }
    }



}

