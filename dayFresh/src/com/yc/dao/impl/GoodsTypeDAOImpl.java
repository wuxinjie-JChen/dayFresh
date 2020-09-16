package com.yc.dao.impl;

import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.GoodsTypeDAO;
import com.yc.po.GoodsTypePO;

public class GoodsTypeDAOImpl implements GoodsTypeDAO{
	DbHelper db=new DbHelper();
	
	@Override
	public List<GoodsTypePO> getInfo() throws Exception {
		String sql="select typeNo,typeName,picture,status from goodstype";
		return db.findMutil(sql, null, GoodsTypePO.class);
	}

}
