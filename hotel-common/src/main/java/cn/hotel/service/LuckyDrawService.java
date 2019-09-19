package cn.hotel.service;

import cn.hotel.entity.LuckyDraw;

import java.util.List;

public interface LuckyDrawService  {

    // 查询全部的商品
    List<LuckyDraw> queryAllLuckyDraw();

    // 查询单个商品
    LuckyDraw detailLuckyDraw(Integer ldId);

    // 修改商品信息
    Integer updateLuckyDraw(LuckyDraw luckyDraw);

    // 增加商品
    Integer insertLuckyDraw(LuckyDraw luckyDraw);

    // 删除商品
    Integer deleteLuckyDraw(Integer ldId);

    // 随机一个物品
    LuckyDraw randomLuckDraw();

}
