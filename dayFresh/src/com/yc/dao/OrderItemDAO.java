package com.yc.dao;

import java.util.List;

import com.yc.vo.OrderItemVO;

public interface OrderItemDAO {

	public List<OrderItemVO> findItem(OrderItemVO vo) throws Exception;
	
	
}
