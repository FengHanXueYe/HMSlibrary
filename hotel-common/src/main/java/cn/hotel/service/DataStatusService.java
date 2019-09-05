package cn.hotel.service;

import cn.hotel.entity.DataStatus;

import java.util.List;

public interface DataStatusService {
    //查询所有客房类型
    List<DataStatus> queryByRommType();

    //查询所有客房状态
    List<DataStatus> queryByRommStatu();
}
