package com.yc.test;

import java.util.List;

import org.junit.Test;

import com.yc.dao.GoodsInfoDAO;
import com.yc.dao.impl.GoodsInfoDAOImpl;
import com.yc.vo.GoodsVO;

public class GoodsInfoDAOTest {
	GoodsInfoDAO dao=new GoodsInfoDAOImpl();
	
	/*@Test
	public void testFindByTypeNo(){
		try {
			List<GoodsInfoPO>list=dao.findByTypeNo(1);
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void testFindByItem(){
		try {
			GoodsVO goods=new GoodsVO();
			goods.setGoodsName("葡");
			List<GoodsVO> list=dao.findByItem(goods,null);
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
