package cn.hotel.hms.service;

import cn.hotel.entity.ConsumptionRecord;
import cn.hotel.entity.Room;
import cn.hotel.hms.mapper.ConsumptionRecordMapper;
import cn.hotel.hms.mapper.RoomLiveinMapper;
import cn.hotel.hms.mapper.RoomMapper;
import cn.hotel.service.RoomService;
import cn.hotel.utils.CreateNumber;
import cn.hotel.utils.PageUtil;
import cn.hotel.vo.RoomLiveinVO;
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

    @Autowired
    private ConsumptionRecordMapper consumptionRecordMapper;

    @Autowired
    private RoomLiveinMapper roomLiveinMapper;

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

    @Override
    public Integer save(RoomLiveinVO roomLiveinVO) {
        //初始化消费账单编号和客房编号
        String Number = CreateNumber.createNo("ConsumptionBill", null);
        String roomLiveinNumber = CreateNumber.createNo("roomLivein", null);
        //创建消费账单实例并注入参数
        ConsumptionRecord con =new ConsumptionRecord();
        //消费类型（客房）
        con.setConType(1);
        //消费场景
        Room room =new Room();
        if(roomLiveinVO.getRoomStatus()==2){//入住
            con.setConScene("客房入住");
            con.setConContent("客户入住房费消费账单");
            //修改当前房间状态
            room.setRoomStatus(2);
        }else if(roomLiveinVO.getRoomStatus()==5){ //预约
            con.setConScene("客房预约");
            con.setConContent("客户预约房费消费账单");
            //修改当前房间状态
            room.setRoomStatus(5);
        }
        //客房编号
        con.setRoomNumber(roomLiveinVO.getRoomNo());
        //消费金额
        con.setConPrice(roomLiveinVO.getConPrice());
        //消费客户名称
        con.setConName(roomLiveinVO.getcName());
        //备注
        con.setConRemarks(roomLiveinVO.getrIRemarks());
        //操作人
        con.setBillConfirmer(roomLiveinVO.getrIOperator());
        //客房类型
        con.setBillstatus(1);
        //账单编号
        con.setConBillNumber(Number);
        //添加消费记录
        consumptionRecordMapper.save(con);
        //添加入住信息
        roomLiveinVO.setrIBillId(Number);
        roomLiveinVO.setrINo(roomLiveinNumber);
        roomLiveinMapper.save(roomLiveinVO);
        //修改当前房间状态
        room.setRoomNumber(roomLiveinVO.getRoomNo());
        roomMapper.updateStatus(room);
        return 1;
    }

    @Override
    public Integer updateStatus(Room room) {
        return roomMapper.updateStatus(room);
    }

    @Override
    public List<Room> queryRoomAllNumber() {
        return roomMapper.queryRoomAllNumber();
    }

    @Override
    public List<Room> queryRoomAllMake() {
        return roomMapper.queryRoomAllMake();
    }


}
