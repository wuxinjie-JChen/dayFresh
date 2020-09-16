package com.yc.test;

import java.util.List;
import org.junit.Test;
import com.yc.dao.GoodsDAO;
import com.yc.dao.impl.GoodsDAOImpl;
import com.yc.po.GoodsPO;

public class GoodsDAOTest {

	GoodsDAO dao=new GoodsDAOImpl();
	@Test
	public void testAddGoods() throws Exception {
		GoodsPO po=new GoodsPO();
		po.setGoodsName("香蕉");
		po.setBalance(50);
		po.setIntro("湖南");
		po.setPrice(22.5);
		po.setQperied("3个月");
		po.setDescr("好吃");
		po.setUnit("个");
		po.setPictures("---");
		po.setTypeNo(2);
		po.setWeight("1kg");
		int a=dao.addGoods(po);
		System.out.println(a);
				
	}

	@Test
	public void testFindByTremGoods() throws Exception {
		GoodsPO po=new GoodsPO();
		po.setGoodsName("香");
		po.setTypeNo(1);
		List<GoodsPO> list=dao.findByTremGoods(po);
		for(GoodsPO goods:list){
			System.out.println(goods.getIntro());
		}
	}

}
