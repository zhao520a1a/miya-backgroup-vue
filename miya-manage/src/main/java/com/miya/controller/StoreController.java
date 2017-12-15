package com.miya.controller;

import com.miya.common.utils.DateTimeUtil;
import com.miya.common.utils.StringUtil;
import com.miya.domain.TbUser;
import com.miya.dto.RespUser;
import com.miya.dto.ResponseModal;
import com.miya.service.impl.UserServiceImpl;
import com.springboot.ping.mybatis.vo.Condition;
import com.springboot.ping.mybatis.vo.Page;
import com.springboot.ping.mybatis.vo.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 赵金鑫
 * @date 2017年10月24日
 */
@Slf4j
@RestController
@RequestMapping("/stores")
public class StoreController {
    private int sumNum;

    @Autowired
    UserServiceImpl userServiceImpl;

    /* 获得用户的总数量 */
    @RequestMapping(value = "/count", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseModal getUsersCount() {
        try {
            Condition condition = null;
            sumNum = (int) userServiceImpl.count(condition);
            log.info("UserCount: {}", sumNum);
        } catch (Exception e) {
            return ResponseModal.builder().code(ResponseModal.RespCode.FAILURE).data(-1).msg("获取用户数量失败").build();
        }
        return ResponseModal.builder().code(ResponseModal.RespCode.OK).data(sumNum).msg("获取用户数量成功").build();
    }


    /* 分页获得用户列表 */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseModal getUsersList(int limit, int offset) {
        log.info("limit:{}, offset:{}", limit, offset);

        Pagination pagination = null;
        Page page = null;
        try {
            pagination = new Pagination();
            int curPage = offset / limit + 1;
            pagination.setTotalCount(sumNum);
            pagination.setPageSize(limit);
            pagination.setCurrentPage(curPage);

            page =  userServiceImpl.find(pagination);

            List<TbUser>  userList = page.getRows();
            List<RespUser> respUserList = new LinkedList<>();
            for(TbUser user: userList){
                RespUser respUser  = RespUser.builder().username(user.getUsername()).phone(user.getPhone()).email(user.getEmail()).build();
                respUser.setCreate_time(DateTimeUtil.formatDate(user.getCreate_time(), "yyyy-MM-dd HH:mm:ss"));
                respUser.setUpdate_time(DateTimeUtil.formatDate(user.getUpdate_time(), "yyyy-MM-dd HH:mm:ss"));
                respUserList.add(respUser);
            }
            page.setRows(respUserList);
        } catch (Exception e) {
            StringUtil.getTrace(e);
            return ResponseModal.builder().code(ResponseModal.RespCode.FAILURE).data("").msg("获取用户列表失败").build();
        }
        return ResponseModal.builder().code(ResponseModal.RespCode.OK).data(page).msg("获取用户列表成功").build();
    }


}
