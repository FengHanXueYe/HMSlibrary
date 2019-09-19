package cn.hotel.service;

import cn.hotel.entity.Luck;

/**
 * 抽奖业务(峰)
 */
public interface LuckService {

    // 抽奖
    Integer insertLuck(Luck luck);

}
