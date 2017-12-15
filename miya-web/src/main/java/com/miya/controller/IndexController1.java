package com.miya.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 赵金鑫
 * @date 2017年10月11日
 */
@Slf4j
@Controller
public class IndexController1 {

    @RequestMapping("/test")
    public String welcome(){
        log.info("加载test页面");
        return "test";
    }




}
