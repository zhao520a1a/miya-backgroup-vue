package com.miya.service.impl;


import com.miya.common.pojo.TaotaoResult;
import com.miya.domain.dao.TbItemParamDao;
import com.miya.domain.TbItemParam;
import com.miya.service.ItemParamService;
import com.springboot.ping.mybatis.extend.service.BaseCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 商品规格参数模板管理
 */
@Service
public class ItemParamServiceImpl extends BaseCURDService<TbItemParam,TbItemParamDao> implements ItemParamService {

	@Autowired
	private TbItemParamDao itemParamDao;
	
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		//判断是否查询到结果
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		//补全pojo
		itemParam.setCreate_time(new Date());
		itemParam.setUpdate_time(new Date());
		//插入到规格参数模板表
		itemParamDao.insert(itemParam);
		return TaotaoResult.ok();
	}

}
