package com.yc.dao;

import java.util.List;
import com.yc.vo.AllOrderVO;
import com.yc.vo.OrderVO;

public interface OrderDAO {

	public List<OrderVO> findOrder(OrderVO vo) throws Exception;
	
	public List<OrderVO> findOrderByPage(OrderVO vo, Integer pageNum, Integer pagesize) throws Exception;
	
	public int findByPageTotal(OrderVO vo) throws Exception;
	
	public int updateItem(OrderVO vo) throws Exception;
	
	/**
	 * 查询所有订单
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public List<List<AllOrderVO>> findOrderByItem(AllOrderVO vo,int memberNo) throws Exception;
}
