package com.yc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.CartInfoDAO;
import com.yc.dao.OrderInfoDAO;
import com.yc.dao.impl.CartInfoDAOImpl;
import com.yc.dao.impl.OrderInfoDAOImpl;
import com.yc.po.MemberPO;
import com.yc.po.OrderPO;
import com.yc.util.getPost;
import com.yc.vo.AllOrderVO;

@WebServlet("/orderInfo.action")
public class OrderInfoServlet extends BaseServlet{
	
	
	OrderInfoDAO dao=new OrderInfoDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -1436495768393557547L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost.setCharacter(request, response);
		MemberPO member=(MemberPO)request.getSession().getAttribute("member");
		if(member==null){
			response.sendRedirect("login.jsp");
			return;
		}
		int memberNo=member.getMeberNo();
		//System.out.println(memberNo);
		String orderOption=request.getParameter("orderOption");
		if(orderOption.equals("findOrder")){
			findAll(request,response,memberNo);
		}else if(orderOption.equals("createOrder")){
			doCreateOrder(request,response);
		}else if(orderOption.equals("addAddr")){
			doAddAddr(request,response);
		}
	}

	private void doAddAddr(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			OrderPO order=new OrderPO();
			MemberPO m=(MemberPO)request.getSession().getAttribute("member");
			int addrNo=Integer.parseInt(request.getParameter("addrNo"));
			String orderNo=request.getParameter("orderNo");
			/*System.out.println(addrNo);
			System.out.println(m.getMeberNo()+"member");*/
			order.setAddrNo(addrNo);
			order.setOrderNo(orderNo);
			order.setMemberNo(m.getMeberNo());
			toPrintJson(response,dao.addAddr(order));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doCreateOrder(HttpServletRequest request, HttpServletResponse response) {
		try {
			String goods=request.getParameter("goodsNo");
			Double totalPrice=Double.parseDouble(request.getParameter("totalPrice"));
			String []a=goods.split(",");
			int [] goodsNo=new int [a.length];
			MemberPO m=(MemberPO)request.getSession().getAttribute("member");
			CartInfoDAO cartdao=new CartInfoDAOImpl();
			int []nums=new int[goodsNo.length];
			for(int i=0;i<a.length;i++){
				goodsNo[i]=Integer.parseInt(a[i]);
				nums[i]=cartdao.findByItem(m.getMeberNo(), goodsNo[i]).get(0).getNum();
			}
			String x= dao.createOrder(m.getMeberNo(),goodsNo,nums,totalPrice);
			toPrintJson(response, x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response,int memberNo) {
		MemberPO m=(MemberPO)request.getSession().getAttribute("member");
		String orderNo=request.getParameter("orderNo");
		//System.out.println(orderNo);
		request.getSession().setAttribute("orderNo", orderNo);
		try {
			List<AllOrderVO>list=dao.findOrderByItem(m.getMeberNo(), orderNo);
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

