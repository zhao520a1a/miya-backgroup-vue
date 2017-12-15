package com.miya.service;


import com.miya.common.pojo.EUTreeNode;
import com.miya.common.pojo.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
