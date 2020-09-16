package com.yc.control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.dao.GoodsDAO;
import com.yc.dao.impl.GoodsDAOImpl;
import com.yc.po.GoodsPO;
import com.yc.util.StringUtil;
import com.yc.util.WebUtil;

@WebServlet("/good.action")
public class GoodServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3059277125076551462L;
	GoodsDAO dao=new GoodsDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebUtil.setEncodings(request, response);
		String op=request.getParameter("op");
		if(op.equals("addGoods")){
			doAddGoods(request,response);
		}else if(op.equals("findByTrem")){
			doFindByTrem(request,response);
		}else if(op.equals("findPage")){
			doFindPage(request,response);
		}else if(op.equals("saveNo")){
			doSave(request,response);
		}else if(op.equals("deleteGoods")){
			doDeleteGoods(request,response);
		}
		
		
		
	}

	
	private void doDeleteGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		GoodsPO po=parseRequest(request, GoodsPO.class);
		try {
			int a=dao.deleteGoods(po);
			toPrintJson(response, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String goodsNo=request.getParameter("goodsNo");
		request.getSession().setAttribute("goodsNo", goodsNo);
		System.out.println(goodsNo);
		//response.sendRedirect("modifyGoods.html");
		request.getRequestDispatcher("modifyGoods.html").forward(request, response);
	}

	private void doFindPage(HttpServletRequest request, HttpServletResponse response) {
		GoodsPO po=parseRequest(request, GoodsPO.class);
		String pagestr=request.getParameter("page");
		String rowStr=request.getParameter("rows");
		String types=request.getParameter("typeNO");
		if(types!=null&&!types.equals("0")){
			int typeNo=Integer.valueOf(types);
			po.setTypeNo(typeNo);
		}
		try {
			int total=dao.findByPageTotal(po);
			List<GoodsPO> list=null;
			if(StringUtil.isNotNull(rowStr)&&StringUtil.isNotNull(pagestr)){
				list=dao.findByPage(po, Integer.parseInt(pagestr), Integer.parseInt(rowStr));
				toPrintJson(response, list,total);
			}else{
				list=dao.findByPage(po, null, null);
				toPrintJson(response, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询
	 * @param request
	 * @param response
	 */
	private void doFindByTrem(HttpServletRequest request, HttpServletResponse response) {
		GoodsPO po=parseRequest(request, GoodsPO.class);
		String types=request.getParameter("typeNO");
		if(types!=null){
			int typeNo=Integer.valueOf(types);
			po.setTypeNo(typeNo);
		}
		String goodsNo=(String) request.getSession().getAttribute("goodsNo");
		if(goodsNo!=null){
			int goodsno=Integer.valueOf(goodsNo);
			po.setGoodsNo(goodsno);
		}
		try {
			List<GoodsPO> list=dao.findByTremGoods(po);
			toPrintJson(response, list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加商品
	 * @param request
	 * @param response
	 */
	private void doAddGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsPO po=parseRequest(request, GoodsPO.class);
		try {
			int a=dao.addGoods(po);
			toPrintJson(response, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
