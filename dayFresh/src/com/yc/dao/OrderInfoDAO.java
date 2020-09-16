package com.yc.dao;

import java.util.List;

import com.yc.po.OrderPO;
import com.yc.vo.AllOrderVO;

public interface OrderInfoDAO {
	
	
	public String createOrder(int memberNo,int[]goodsNo,int []nums,Double totalPrice) throws Exception;

	/**
	 * 根据条件查找订单
	 * @param allOrderVO
	 * @return
	 */
	public List<AllOrderVO> findOrderByItem(int memberNo,String orderNo) throws Exception;
	
	
	/**
	 * 添加地址
	 * @param orderNo
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int addAddr(OrderPO order) throws Exception;
}
