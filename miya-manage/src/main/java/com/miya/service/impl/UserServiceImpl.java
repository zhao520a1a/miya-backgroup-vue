package com.miya.service.impl;


import com.miya.common.pojo.TaotaoResult;
import com.miya.domain.TbItemParam;
import com.miya.domain.TbUser;
import com.miya.domain.dao.TbItemParamDao;
import com.miya.domain.dao.TbUserDao;
import com.miya.service.UserService;
import com.springboot.ping.mybatis.extend.service.BaseCURDService;
import com.springboot.ping.mybatis.vo.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 商品规格参数模板管理
 */
@Service
public class UserServiceImpl extends BaseCURDService<TbUser,TbUserDao> implements UserService {

	@Autowired
	private TbUserDao tbUserDao;



}
