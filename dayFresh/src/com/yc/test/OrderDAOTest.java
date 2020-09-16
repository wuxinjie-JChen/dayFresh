package com.yc.test;

import java.util.List;
import org.junit.Test;
import com.yc.dao.OrderDAO;
import com.yc.dao.impl.OrderDAOImpl;
import com.yc.vo.OrderVO;

public class OrderDAOTest {

	OrderDAO dao=new OrderDAOImpl();
	@Test
	public void testFindOrder() {
		OrderVO vo=new OrderVO();
	
		try {
			List<OrderVO> list=dao.findOrder(vo);
			for(OrderVO order:list){
				System.out.println(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testFindOrderByPage() {
		OrderVO vo=new OrderVO();
		
		int pageNum=1;
		int pagesize=1;
		try {
			List<OrderVO> list=dao.findOrderByPage(vo, pageNum, pagesize);
			for(OrderVO order:list){
				System.out.println(order.getOrderNo());
			}
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindOrderByItem() {
		try {
			dao.findOrderByItem(null,123456);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testCreateOrder() {
		/*OrderInfoDAO dao=new OrderInfoDAOImpl();
		try {
			AllOrderVO allOrderVO=new AllOrderVO();
			allOrderVO.setMemberNo(123456);
			allOrderVO.setGoodsNo(2);
			allOrderVO.setNums(6);
			int []goodsNo={6};
			int []nums={2};
			//int i=dao.createOrder(123456,goodsNo,nums);
			//System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
