package cn.hotel.service;

import cn.hotel.entity.Remind;

import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-26 14:16
 */
public interface RemindService {

    //添加消息通知
    Integer addRemind(Remind remind);

    //修改消息通知状态
    Integer updateRemind(Remind remind);

    //删除消息通知
    Integer delRemind(Integer pk);

    //根据所属部门查询所有消息通知
    List<Remind>  queryRemindAll(Remind remind);

    //查询指定详细信息根据主键
    Remind  queryRemindByReId(Integer reId);
}
