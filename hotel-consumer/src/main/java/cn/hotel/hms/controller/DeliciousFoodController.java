package cn.hotel.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeliciousFoodController {

    @RequestMapping(value = "queryAllFood")
    public String toIndex(){
        return "food/food_list";
    }
}
