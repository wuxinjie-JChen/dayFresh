package com.yc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.OrderItemDAO;
import com.yc.dao.impl.OrderItemDAOImpl;
import com.yc.util.WebUtil;
import com.yc.vo.OrderItemVO;

@WebServlet("/orderItem.action")
public class OrderItemServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4245026257204571109L;
	OrderItemDAO dao=new OrderItemDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebUtil.setEncodings(request, response);
		String op=request.getParameter("op");
		if(op.equals("showItem")){
			doShowItem(request,response);
		}
	}

	/**
	 * 订单详情
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doShowItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderItemVO vo=parseRequest(request, OrderItemVO.class);
		//String orderid=request.getParameter("orderNo");
		try {
			List<OrderItemVO> list=dao.findItem(vo);
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
