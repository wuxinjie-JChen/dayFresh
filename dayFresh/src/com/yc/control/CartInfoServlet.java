package com.yc.control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yc.dao.CartInfoDAO;
import com.yc.dao.impl.CartInfoDAOImpl;
import com.yc.po.MemberPO;
import com.yc.util.getPost;
import com.yc.vo.CartInfoVO;

@WebServlet("/cart.action")
public class CartInfoServlet extends BaseServlet{
	CartInfoDAO cartdao=new CartInfoDAOImpl();
	private static Logger logger = Logger.getLogger(CartInfoServlet.class); 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1645890262083609183L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		getPost.setCharacter(request, response);
		String cartOption=request.getParameter("cartOption");
		MemberPO member=(MemberPO)request.getSession().getAttribute("member");
		if(member==null){
			//System.out.println(12);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		int memberNo=member.getMeberNo();
		if(cartOption.equals("findAll")){
			findAll(request,response,memberNo);
		}else if(cartOption.equals("addCart")){
			logger.info("addCart");
			addCart(request,response,memberNo);
		}else if(cartOption.equals("addMinusNum")){
			addMinusNum(request,response,memberNo);
		}else if(cartOption.equals("delGoods")){
			delGoods(request,response,memberNo);
		}
	}

	private void delGoods(HttpServletRequest request, HttpServletResponse response,int memberNo) {
		try {
			int goodsNo=Integer.parseInt(request.getParameter("goodsNo"));
			cartdao.delgoods(memberNo, goodsNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addMinusNum(HttpServletRequest request, HttpServletResponse response,int memberNo) {
		String op=request.getParameter("op");
		int goodsNo=Integer.parseInt(request.getParameter("goodsNo"));
		try {
			cartdao.addCart(op,memberNo,goodsNo,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response,int memberNo) {
		String url = request.getContextPath();
		System.setProperty("LOG_DIR", url);
		System.out.println(url);
		try {
			/*if(request.getSession().getAttribute("member")==null){
				response.sendRedirect("login.jsp");
				return ;
			}*/
			int goodsNo=Integer.parseInt(request.getParameter("goodsNo"));
			String num=request.getParameter("nums");
			int nums=1;
			if(num!=null && num.length()>0){
				nums=Integer.parseInt(request.getParameter("nums"));
			} 
			String op=request.getParameter("op");
			logger.info("op"+op+"memberNo："+memberNo+"goodsNo:"+goodsNo+"nums:"+nums);
			int row=cartdao.addCart(op,memberNo,goodsNo,nums);
			logger.info("row"+row);
			toPrintJson(response, row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response,int memberNo) {
		try {
			if(request.getSession().getAttribute("member")==null){
				response.sendRedirect("login.jsp");
				return;
			}
			List<CartInfoVO> list= cartdao.findAll(memberNo);
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
