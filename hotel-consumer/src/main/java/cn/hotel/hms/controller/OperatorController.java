package cn.hotel.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorController {

    @RequestMapping(value = "toOperator")
    public String toOperator(){
        return "personnel/Operator";
    }


}
