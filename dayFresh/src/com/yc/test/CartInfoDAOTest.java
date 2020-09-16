package com.yc.test;

import java.util.List;
import org.junit.Test;

import com.yc.dao.CartInfoDAO;
import com.yc.dao.impl.CartInfoDAOImpl;
import com.yc.vo.CartInfoVO;

public class CartInfoDAOTest {
	CartInfoDAO dao=new CartInfoDAOImpl(); 
	@Test
	public void testFindAll(){
		try {
			List<CartInfoVO> list=dao.findAll(123456);
			System.out.println(list.get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelGoods(){
		try {
			int i=dao.delgoods(123456, 2);
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
