package com.miya.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 赵金鑫
 * @date 2017年10月11日
 */
@Slf4j
@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView welcome(){
        ModelAndView mv = new ModelAndView("index");
        log.info("加载index页面");
        return mv;
    }




}
