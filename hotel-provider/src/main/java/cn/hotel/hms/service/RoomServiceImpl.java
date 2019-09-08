package cn.hotel.hms.service;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.Room;
import cn.hotel.hms.mapper.RoomMapper;
import cn.hotel.service.RoomService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.RoomVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public PageUtil<RoomVO> queryAll(Room room, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RoomVO> list = roomMapper.queryAll(room);
        PageInfo<RoomVO> pageInfo =new PageInfo<>(list);
        PageUtil<RoomVO> pageUtil =new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalPageCount(pageInfo.getPages());
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageUtil.setList(pageInfo.getList());

        return pageUtil;
    }


    @Override
    public RoomVO queryByNumber(String no) {
        return roomMapper.queryByNumber(no);
    }


}
