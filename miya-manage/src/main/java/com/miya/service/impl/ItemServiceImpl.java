package com.miya.service.impl;


import com.miya.common.pojo.EUDataGridResult;
import com.miya.common.pojo.TaotaoResult;
import com.miya.domain.dao.TbItemDescDao;
import com.miya.domain.dao.TbItemParamItemDao;
import com.miya.domain.TbItem;
import com.miya.domain.dao.TbItemDao;
import com.miya.domain.TbItemDesc;
import com.miya.domain.TbItemParamItem;
import com.miya.service.ItemService;
import com.springboot.ping.mybatis.extend.service.BaseCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 商品管理Service
 */
@Service
public class ItemServiceImpl extends BaseCURDService<TbItem,TbItemDao> implements ItemService {

	@Autowired
	private TbItemDao itemDao;
	
	@Autowired
	private TbItemDescDao itemDescDao;
	
	@Autowired
	private TbItemParamItemDao itemParamItemDao;
	
	@Override
	public TbItem getItemById(long itemId) {
		TbItem item = TbItem.builder().id(itemId).build();
		return itemDao.findByPk(item);
	}

	/**
	 * 商品列表查询
	 */
	//@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		//分页处理
		//创建一个返回值对象
		//取记录总条数
		return null;
	}

	@Override
	public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception {
		//item补全
		//生成商品ID
		// '商品状态，1-正常，2-下架，3-删除',
		//插入到数据库
		//添加商品描述信息
		//添加规格参数
		return TaotaoResult.ok();
	}
	/**
	 * 添加商品描述
	 */
	private TaotaoResult insertItemDesc(Long itemId, String desc) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreate_time(new Date());
		itemDesc.setUpdate_time(new Date());
		itemDescDao.insert(itemDesc);
		return TaotaoResult.ok();
	}

	/**
	 * 添加规格参数
	 */
	private TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
		//创建一个pojo
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreate_time(new Date());
		itemParamItem.setUpdate_time(new Date());
		//向表中插入数据
		itemParamItemDao.insert(itemParamItem);

		return TaotaoResult.ok();

	}

}
