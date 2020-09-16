package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.yc.commons.DbHelper;
import com.yc.dao.OrderItemDAO;
import com.yc.vo.OrderItemVO;

public class OrderItemDAOImpl implements OrderItemDAO {

	DbHelper db=new DbHelper();
	@Override
	public List<OrderItemVO> findItem(OrderItemVO vo) throws Exception {
		String sql="select orderItemNo,orderNo,o.goodsNo,nums,g.price,status,"
				+ "typeNo,balance,goodsName,intro,pictures,unit,qperied,weight,"
				+ "descr from orderiteminfo o inner join goodsinfo g "
				+ " where o.goodsNo=g.goodsNo and orderNo=?";
		List<Object> params=new ArrayList<Object>();
		params.add(vo.getOrderNo());
		return db.findMutil(sql, params, OrderItemVO.class);
	}

}
