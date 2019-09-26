package cn.hotel.service;

import cn.hotel.dto.TokenDto;
import cn.hotel.vo.OperatorVO;

/**
 * Created by Administrator on 2019/8/26/026.
 */
public interface TokenService {

    //生成Token
    String createToken(String userAgent, OperatorVO operator);
    //保存Token
    Integer saveToken(String token, OperatorVO operator);
    //验证Token
    Boolean checkToken(String token, String userAgent);

    //退出
    TokenDto logout(String token, String userAgent);

    //重置Token
    TokenDto reset(String token, String userAgent);
}
