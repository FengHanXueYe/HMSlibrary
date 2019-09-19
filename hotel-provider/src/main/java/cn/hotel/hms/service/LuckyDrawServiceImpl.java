package cn.hotel.hms.service;

import cn.hotel.entity.LuckyDraw;
import cn.hotel.hms.mapper.LuckyDrawMapper;
import cn.hotel.service.LuckyDrawService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class LuckyDrawServiceImpl implements LuckyDrawService {

    @Autowired
    private LuckyDrawMapper luckyDrawMapper;

    @Override
    public List<LuckyDraw> queryAllLuckyDraw() {
        return luckyDrawMapper.queryAllLuckyDraw();
    }

    @Override
    public LuckyDraw detailLuckyDraw(Integer ldId) {
        return luckyDrawMapper.detailLuckyDraw(ldId);
    }

    @Override
    public Integer updateLuckyDraw(LuckyDraw luckyDraw) {
        return luckyDrawMapper.updateLuckyDraw(luckyDraw);
    }

    @Override
    public Integer insertLuckyDraw(LuckyDraw luckyDraw) {
        return luckyDrawMapper.insertLuckyDraw(luckyDraw);
    }

    @Override
    public Integer deleteLuckyDraw(Integer ldId) {
        return luckyDrawMapper.deleteLuckyDraw(ldId);
    }

    @Override
    public LuckyDraw randomLuckDraw() {
        return luckyDrawMapper.randomLuckDraw();
    }
}
