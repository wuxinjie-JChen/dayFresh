package com.yc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.OrderDAO;
import com.yc.dao.impl.OrderDAOImpl;
import com.yc.po.MemberPO;
import com.yc.util.StringUtil;
import com.yc.util.WebUtil;
import com.yc.vo.AllOrderVO;
import com.yc.vo.OrderVO;

@WebServlet("/order.action")
public class OrderServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8100639800053793432L;
	OrderDAO dao=new OrderDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=request.getParameter("op");
		WebUtil.setEncodings(request, response);
		if(op.equals("findByPage")){
			doFindByPage(request,response);
		}else if(op.equals("findByTrem")){
			doFindByTrem(request,response);
		}else if(op.equals("fahuo")){
			doFahuo(request,response);
		}else if(op.equals("findAllOrder")){
			doFindAllOrder(request,response);
		}else if(op.equals("payOk")){
			doPayOk(request,response);
		}
	}

	/**
	 * 支付完成
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doPayOk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String orderNo=(String) request.getSession().getAttribute("orderNo");
		OrderVO vo=new OrderVO();
		vo.setOrderNo(orderNo);
		vo.setStatus(1);
		try {
			int a=dao.updateItem(vo);
			toPrintJson(response, a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doFindAllOrder(HttpServletRequest request, HttpServletResponse response) {
		MemberPO member=(MemberPO)request.getSession().getAttribute("member");
		try {
			if(member==null){
				response.sendRedirect("login.jsp");
				return;
			}
			List<List<AllOrderVO>> list=dao.findOrderByItem(null, member.getMeberNo());
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doFahuo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		OrderVO vo=parseRequest(request, OrderVO.class);
		String fh=request.getParameter("fh");
		System.out.println(fh);
		if(fh.equals("已发货")){
			toPrintJson(response, 0);
			return;
		}else{
			try {
				vo.setStatus(2);
				int a=dao.updateItem(vo);
				toPrintJson(response, a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void doFindByTrem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		OrderVO vo=parseRequest(request, OrderVO.class);
		try {
			List<OrderVO> list=null;
			if(vo.getOrderNo()!=null&&!vo.getOrderNo().equals("")){
				list=dao.findOrder(vo);
			}
			toPrintJson(response, list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doFindByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		OrderVO vo=parseRequest(request, OrderVO.class);
		String pagestr=request.getParameter("page");
		String rowStr=request.getParameter("rows");
		String statu=request.getParameter("statu");
		if(statu!=null&&!statu.equals("9")){
			vo.setStatus(Integer.valueOf(statu));
		}
		//System.out.println(pagestr+"+"+rowStr+"-"+statu);
		try {
			int total=dao.findByPageTotal(vo);
			List<OrderVO> list=null;
			if(StringUtil.isNotNull(rowStr)&&StringUtil.isNotNull(pagestr)){
				list=dao.findOrderByPage(vo, Integer.parseInt(pagestr), Integer.parseInt(rowStr));
				toPrintJson(response, list,total);
			}else{
				list=dao.findOrderByPage(vo, null, null);
				toPrintJson(response, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
