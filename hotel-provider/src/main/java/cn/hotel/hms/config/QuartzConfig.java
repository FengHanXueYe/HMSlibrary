package cn.hotel.hms.config;


import cn.hotel.entity.*;
import cn.hotel.service.*;
import cn.hotel.vo.MemberShipScoreVO;
import cn.hotel.vo.SchedulingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
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

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private SchedulingService schedulingService;
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

    List<SchedulingVO> list = new ArrayList<>();
    /**
     * 排班
     */
    @Scheduled(cron = "*/5 * * * * *")
    public void scheduling(){
        System.out.println("---------"+list.size());
        // 查询排班表中是否有人员
        List<SchedulingVO> schedulingVOS = schedulingService.queryAllScheduling();
        // 没有值班人员 生成
        if(schedulingVOS.size()<=0){
            // 查询排班的人员
            List<Operator> operator = operatorService.queryAllOperatorAndScheduling();
            // 放到排班人员表中
            for (Operator o : operator) {
                Scheduling scheduling = new Scheduling();
                scheduling.setSOId(o.getOId());
                schedulingService.insertScheduling(scheduling);
                // 将人员放到集合中
            }
            // 再次查询
            List<SchedulingVO> s = schedulingService.queryAllScheduling();
            for (SchedulingVO schedulingVO : s) {
                System.out.println(">>>>>"+schedulingVO);
                list.add(schedulingVO);
            }
            Scheduling scheduling = new Scheduling();
            scheduling.setSId(1);
            scheduling.setSStatus(2);
            // 修改当前值班人员状态
            schedulingService.updateScheduling(scheduling);
        }else{
            // 将修改上一个班的值班人员的值班状态
            Scheduling s1 = new Scheduling();
            s1.setSId(list.get(0).getSId());
            s1.setSStatus(1);
            schedulingService.updateScheduling(s1);
            // 删除第一个
            list.remove(0);
            // 修改状态当前值班人员状态
            /**
             * 判断当删除上一个值班人员后，如果list中已经没有元素
             * 那么本次轮班结束 开始下一轮的轮班 清空 值班表
             */
            if(list.size()<=0){
                schedulingService.truncateTableScheduling();
                scheduling();
            }else{
                Scheduling s2 = new Scheduling();
                s2.setSId(list.get(0).getSId());
                s2.setSStatus(2);
                schedulingService.updateScheduling(s2);
            }

        }
    }



}

