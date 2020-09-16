package com.yc.dao;

import java.util.List;

import com.yc.vo.CartInfoVO;

public interface CartInfoDAO {
	
	public List<CartInfoVO> findAll(int memberNo) throws Exception;

	/**
	 * 添加购物车
	 * @param cartInfo
	 * @return
	 * @throws Exception
	 */
	public int addCart(String op,int memberNo,int goodsNo,int nums) throws Exception; 
	
	
	public List<CartInfoVO> findByItem(int memberNo,int goodsNo) throws Exception ;

	/**
	 * 删除商品信息
	 * @param memberNo
	 * @param goodsNo
	 * @return
	 * @throws Exception
	 */
	public int delgoods(int memberNo, int goodsNo) throws Exception;
	
	/**
	 * 购物车goods数量加减
	 * @param op
	 * @param memberNo
	 * @param goodsNo
	 * @return
	 * @throws Exception
	 *//*
	public int addCart(String op,int memberNo,int goodsNo) throws Exception; */
}
