package com.yc.dao;

import java.util.List;

import com.yc.po.GoodsInfoPO;
import com.yc.vo.GoodsVO;

public interface GoodsInfoDAO {
	
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<GoodsVO> findAll()throws Exception;
	
	/**
	 * 根据条件查询
	 * @return
	 * @throws Exception
	 */
	public List<GoodsVO> findByItem(GoodsVO goods,String typeNo)throws Exception;

	public List<GoodsInfoPO> findAllGoods() throws Exception;
}
