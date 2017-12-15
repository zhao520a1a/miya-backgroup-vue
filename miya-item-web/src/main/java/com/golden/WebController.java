package com.golden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 赵金鑫
 * @date 2017年11月01日
 */

@Controller
public class WebController {



    @RequestMapping("/")
    public String web (ModelMap map ){
        return "item";
    }

}
