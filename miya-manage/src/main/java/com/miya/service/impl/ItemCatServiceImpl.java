package com.miya.service.impl;


import com.miya.common.pojo.EUTreeNode;
import com.miya.domain.dao.TbItemCatDao;
import com.miya.domain.TbItemCat;
import com.miya.service.ItemCatService;
import com.springboot.ping.mybatis.extend.service.BaseCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl extends BaseCURDService<TbItemCat,TbItemCatDao> implements ItemCatService {

	@Autowired
	private TbItemCatDao itemCatDao;
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		//创建查询条件
		//根据条件查询
		//把列表转换成treeNodelist
		//返回结果
		return null;
	}

}
