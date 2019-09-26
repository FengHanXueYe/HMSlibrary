package cn.hotel.hms.controller;

import cn.hotel.dto.TokenDto;
import cn.hotel.service.TokenService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/8/28/028.
 */
@RestController
@RequestMapping("token")
public class TokenController {

    @Reference
    private TokenService tokenService;

    @RequestMapping(value = "reset",method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    public String reset(HttpServletRequest request) {
        //从header中获取token和userAgent
        String token=request.getHeader("token");
        String userAgent = request.getHeader("User-Agent");
        //调用业务层方法token重置
        TokenDto tokenDto = tokenService.reset(token, userAgent);
        //返回
        return JSON.toJSONString(tokenDto);
    }


}
