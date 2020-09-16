package com.yc.dao;

import java.util.List;

import com.yc.po.GoodsTypePO;

public interface GoodsTypeDAO {
	
	public List<GoodsTypePO> getInfo() throws Exception;
}
