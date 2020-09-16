package com.yc.dao;

import java.util.List;
import com.yc.po.GoodsPO;

public interface GoodsDAO {

	public int addGoods(GoodsPO po) throws Exception;
	
	public List<GoodsPO> findByTremGoods(GoodsPO po) throws Exception;
	
	/**
	 * 分页查询
	 * @param po
	 * @param pageNum
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public List<GoodsPO> findByPage(GoodsPO po,Integer pageNum,Integer pagesize) throws Exception;
	
	/**
	 * 分页数据的总条数
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int findByPageTotal(GoodsPO po) throws Exception;
	
	//修改
	public int modifyGoodsPO(GoodsPO po) throws Exception;
	
	public int deleteGoods(GoodsPO po) throws Exception;
}
