package cn.hotel.service;

import cn.hotel.entity.DataStatus;

import java.util.List;

public interface DataStatusService {
    //根据指定code的查询
    List<DataStatus> queryByCode(String code);

}
