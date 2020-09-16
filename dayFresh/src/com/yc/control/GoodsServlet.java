package com.yc.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.dao.GoodsInfoDAO;
import com.yc.dao.impl.GoodsInfoDAOImpl;
import com.yc.po.GoodsInfoPO;
import com.yc.util.StringUtil;
import com.yc.vo.GoodsVO;

@WebServlet("/goods.action")
public class GoodsServlet extends BaseServlet{
	//GoodsTypeDAO typeDao=new GoodsTypeDAOImpl();
	GoodsInfoDAO infoDao=new GoodsInfoDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -5902460232490620265L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String option=request.getParameter("goodsOption");
		if(option.equals("findType")){
			findType(request,response);
		}else if(option.equals("findByGoodsNo")){
			findByGoodsNo(request,response);
		}else if(option.equals("findByGoodsName")){
			findByGoodsName(request,response);
		}else if(option.equals("findGoods")){
			findGoods(request,response);
		}else if(option.equals("findNewGoods")){
			findNewGoods(request,response);
		}else if(option.equals("TypeOrder")){
			//TypeOrder(request,response);
		}
	}

	/*private void TypeOrder(HttpServletRequest request, HttpServletResponse response) {
		String type=request.getParameter("type");
		String goodsName=request.getParameter("goodsName");
		GoodsVO goods=new GoodsVO();
		goods.setGoodsName(goodsName);
		try {
			if(type.equals("id")){
				goods.setGoodsNo(goodsNo);
			}else if(type.equals("gprice")){
				goods.setPrice(price);
			}else if(type.equals("gsales")){
				
			}
			List<GoodsVO> list = infoDao.findByItem(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	private void findNewGoods(HttpServletRequest request, HttpServletResponse response) {
		List<GoodsInfoPO> list;
		try {
			list = infoDao.findAllGoods();
			List<GoodsInfoPO> list1=new ArrayList<GoodsInfoPO>();
			for(int num=0;num<2;num++){
				int i=(int)(Math.random()*list.size());
				if(num==1 && list1.get(0).getGoodsNo()==list.get(i).getGoodsNo()){
					num=1;
					continue;
				}
				list1.add(list.get(i));
			}
			toPrintJson(response, list1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void findGoods(HttpServletRequest request, HttpServletResponse response) {
		String goodsName=request.getParameter("goodsName");
		String goodsNo=request.getParameter("goodsNo");
		if(StringUtil.isNotNull(goodsName)&& !StringUtil.isNotNull(goodsNo)){
			findByGoodsName(request,response);
		}else if(!StringUtil.isNotNull(goodsName)&& StringUtil.isNotNull(goodsNo)){
			findByGoodsNo(request,response);
		}
	}

	/*private void findGoodsInfo(HttpServletRequest request, HttpServletResponse response) {
		int typeNo=Integer.parseInt(request.getParameter("typeNo"));
		try {
			List<GoodsInfoPO> list=infoDao.findByTypeNo(typeNo);
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	private void findByGoodsName(HttpServletRequest request, HttpServletResponse response) {
		try {
			String goodsName=request.getParameter("goodsName");
			String typeNo=request.getParameter("typeNo");
			//System.out.println(typeNo+"/////");
			GoodsVO goods=null;
			List<GoodsVO> list=null;
			if((goodsName==null || goodsName.length()<=0) && typeNo!=null&&typeNo.length()>0){
				list = infoDao.findByItem(goods,typeNo);
			}else{
				goods=new GoodsVO();
				goods.setGoodsName(goodsName);
				list = infoDao.findByItem(goods,null);
			}
			//System.out.println(list.size());
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void findByGoodsNo(HttpServletRequest request, HttpServletResponse response) {
		int goodsNo=Integer.parseInt(request.getParameter("goodsNo"));
		GoodsVO goods=new GoodsVO();
		goods.setGoodsNo(goodsNo);
		try {
			List<GoodsVO> list=infoDao.findByItem(goods,null);
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findType(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<GoodsVO> list=infoDao.findAll();
			toPrintJson(response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
