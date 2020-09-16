package com.yc.test;

import java.util.List;
import org.junit.Test;
import com.yc.dao.OrderItemDAO;
import com.yc.dao.impl.OrderItemDAOImpl;
import com.yc.vo.OrderItemVO;

public class OrderItemDAOTest {

	OrderItemDAO dao=new OrderItemDAOImpl();
	@Test
	public void testFindItem() {
		OrderItemVO vo=new OrderItemVO();
		vo.setOrderNo("999");
		try {
			List<OrderItemVO> list=dao.findItem(vo);
			for(OrderItemVO o:list){
				System.out.println(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
