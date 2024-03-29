package cn.hotel.common;

import cn.hotel.vo.MemberShipScoreVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class HotelCommon implements Serializable {

    // 会员积分
    public MemberShipScoreVO MEMBERSHIPSCOREVO;
    public HotelCommon(){
        if(null == MEMBERSHIPSCOREVO){
            MEMBERSHIPSCOREVO = new MemberShipScoreVO();
        }
    }

    public void setMEMBERSHIPSCOREVO(MemberShipScoreVO membershipscorevo){
        this.MEMBERSHIPSCOREVO = membershipscorevo;
    }

    public MemberShipScoreVO getMEMBERSHIPSCOREVO(){
        return MEMBERSHIPSCOREVO;
    }

}
