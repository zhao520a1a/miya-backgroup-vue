package com.miya.controller;

import com.miya.dto.AdminInfo;
import com.miya.dto.ReqUser;
import com.miya.dto.ResponseModal;
import com.springboot.ping.mybatis.vo.Condition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理员模块
 * @author 赵金鑫
 * @date 2017年10月25日
 */

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    String img_url = "http://10.106.204.12/group1/M00/00/00/CmrMDFoAs0yAMfD8AAUbNfBOdMg715.jpg";
    AdminInfo adminInfo = AdminInfo.builder().admin("管理员").id(11).user_name("Godlen").create_time("2017-11-11").avatar(img_url).build();


    // 登陆
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseModal login(@RequestBody ReqUser reqUser) {
        log.info(reqUser.toString());
        try {
            Condition condition = null;
            //获得管理员的详细信息
        } catch (Exception e) {
            return ResponseModal.builder().code(ResponseModal.RespCode.FAILURE).data("").msg("用户登陆失败").build();
        }
        return ResponseModal.builder().code(ResponseModal.RespCode.OK).data("").msg("用户登陆成功").build();
    }

    //退出
    @RequestMapping(value = "/singout", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseModal singout() {
        return ResponseModal.builder().code(ResponseModal.RespCode.OK).data("").msg("用户退出成功").build();
    }

    //详细信息
    @RequestMapping(value = "/info" )
    public ResponseModal info() {
        log.info("获得管理员的详细信息");
        return ResponseModal.builder().code(ResponseModal.RespCode.OK).data(adminInfo).msg("获得管理员信息成功").build();
    }


    @RequestMapping(value = "/all", method = {RequestMethod.POST, RequestMethod.GET})
    public Map getAdminList(@RequestBody ReqUser reqUser) {
        log.info(reqUser.toString());

        Map map = new HashMap();
        map.put("status", 1);
        return map;
    }

    //
    @RequestMapping(value = "/count", method = {RequestMethod.POST, RequestMethod.GET})
    public Map getAdminsCount(@RequestBody ReqUser reqUser) {
        log.info(reqUser.toString());

        Map map = new HashMap();
        map.put("status", 1);
        return map;
    }
}
