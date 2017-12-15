package com.miya.domain.dao;

import com.miya.domain.TbUser;
import com.springboot.ping.mybatis.extend.dao.BaseCURDDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TbUserDao extends BaseCURDDao<TbUser> {

    List<TbUserDao> selectLastDates(@Param("num")int num, @Param("is_holiday")String is_holiday);

}