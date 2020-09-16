package com.yc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.yc.dao.OrderInfoDAO;
import com.yc.dao.impl.OrderInfoDAOImpl;
import com.yc.vo.AllOrderVO;

public class OrderInfoDAOTest {

	OrderInfoDAO dao=new OrderInfoDAOImpl();
	@Test
	public void testFindOrderByItem() {
		AllOrderVO vo=new AllOrderVO();
		vo.setOrderNo("1569677030280934");
		try {
			List<AllOrderVO> list=dao.findOrderByItem(4, "1569677030280934");
			for(AllOrderVO v:list){
				System.out.println(v.getPrice()+"---");
			}
			System.out.println(list+"+++");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
