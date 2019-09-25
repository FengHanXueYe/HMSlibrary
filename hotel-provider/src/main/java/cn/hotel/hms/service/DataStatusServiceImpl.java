package cn.hotel.hms.service;

import cn.hotel.entity.DataStatus;
import cn.hotel.hms.mapper.DataStatusMapper;
import cn.hotel.service.DataStatusService;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.DataStatusVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DataStatusServiceImpl implements DataStatusService {

    @Autowired
    private DataStatusMapper dataStatusMapper;

    @Override
    public PageUtil<DataStatusVO> queryAll(DataStatus status,Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<DataStatusVO> list = dataStatusMapper.queryAll(status);
        PageInfo<DataStatusVO> pageInfo=new PageInfo<>(list);
        PageUtil<DataStatusVO> pageUtil=new PageUtil<>();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setNavigatepageNums(pageInfo.getNavigatepageNums());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalPageCount(pageInfo.getPages());
        pageUtil.setList(pageInfo.getList());
        return pageUtil;
    }

    @Override
    public List<DataStatus> queryByCode(String code) {
        return dataStatusMapper.queryByCode(code);
    }

    @Override
    public Integer save(DataStatus status) {
        return dataStatusMapper.save(status);
    }

    @Override
    public Integer update(DataStatus status) {
        return dataStatusMapper.update(status);
    }

    @Override
    public DataStatusVO queryById(Integer id) {
        return dataStatusMapper.queryById(id);
    }

    @Override
    public Integer delById(Integer id) {
        return dataStatusMapper.delById(id);
    }

}
