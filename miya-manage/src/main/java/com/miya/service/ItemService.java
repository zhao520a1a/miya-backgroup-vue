package com.miya.service;


import com.miya.common.pojo.EUDataGridResult;
import com.miya.common.pojo.TaotaoResult;
import com.miya.domain.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
