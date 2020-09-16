package com.yc.test;

import java.util.List;

import org.junit.Test;

import com.yc.dao.GoodsTypeDAO;
import com.yc.dao.impl.GoodsTypeDAOImpl;
import com.yc.po.GoodsTypePO;

public class GoodsTypeDAOTest {
	GoodsTypeDAO dao=new GoodsTypeDAOImpl() ;
	
	@Test
	public void testGetInfo(){
		try {
			List<GoodsTypePO> list=dao.getInfo();
			for(GoodsTypePO g:list){
				System.out.println(g.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
