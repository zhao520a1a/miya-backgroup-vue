package com.miya.service;


import com.miya.common.pojo.TaotaoResult;
import com.miya.domain.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
}
