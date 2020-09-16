package com.yc.dao.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.yc.commons.DbHelper;
import com.yc.dao.OrderInfoDAO;
import com.yc.po.OrderPO;
import com.yc.util.StringUtil;
import com.yc.vo.AllOrderVO;

public class OrderInfoDAOImpl implements OrderInfoDAO{
	DbHelper db=new DbHelper();
	
	/**
	 * 创建订单
	 */
	public String createOrder(int memberNo,int[]goodsNo,int []nums,Double totalPrice){
		int num=0;
		String orderNo="";
		try {
			orderNo=StringUtil.genOrderId();
			Date date=new Date();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			
			List<String> sqls=new ArrayList<String>();
			List<List<Object>> params=new ArrayList<List<Object>>();
			
			String sql01="insert into orderinfo values(?,?,null,null,null,0,?,0,?)";
			sqls.add(sql01);
			List<Object>params01=new ArrayList<Object>();
			params01.add(orderNo);
			params01.add(df.format(date));
			params01.add(totalPrice);
			params01.add(memberNo);
			params.add(params01);
			
			for(int i=0;i<goodsNo.length;i++){
				String sql02="insert into orderiteminfo values(null,?,?,?,null,0)";
				sqls.add(sql02);
				//System.out.println(orderNo);
				List<Object> params02=new ArrayList<Object>();
				params02.add(orderNo);
				params02.add(goodsNo[i]);
				params02.add(nums[i]);
				params.add(params02);
				
				String sql03="delete from cartinfo where memberNo=? and goodsNo=?";
				sqls.add(sql03);
				List<Object>params03=new ArrayList<Object>();
				params03.add(memberNo);
				params03.add(goodsNo[i]);
				params.add(params03);
			}
			
			
			num= db.update(sqls, params);
			if(num<=0){
				orderNo="";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderNo;
	}
	
	
	public List<AllOrderVO> findOrderByItem(int memberNo,String orderNo) throws Exception{
		/*String sqlAddr="select memberNo from addrinfo where memberNo=?";
		List<Map<String ,Object>> result=db.selectMutil(sqlAddr, params);*/
		String sql="select pictures,goodsName,unit,gi.price,oii.nums from "
				+" orderinfo oi,goodsinfo gi,orderiteminfo oii where oi.orderNo=oii.orderNo"
				+" and gi.goodsNo=oii.goodsNo and oi.memberNo=? and oi.orderNo=?";
				
				/*"select a.addrNo addrNo,pictures,goodsName,unit,gi.price,oii.nums,name,tel,province,"
				+" city,area,addr from orderinfo oi,goodsinfo gi,orderiteminfo oii,"
				+" addrinfo a where oi.orderNo=oii.orderNo and gi.goodsNo=oii.goodsNo AND"
				+" oi.memberNo=? and  oi.orderNo=? ";*/
		/*if(result!=null){
			sql+= " and oi.memberNo=a.memberNo";
		}*/
		List<Object> params =new ArrayList<Object>();
		params.add(memberNo);
		params.add(orderNo);
		List<AllOrderVO> list=new ArrayList<AllOrderVO>();
		list= db.findMutil(sql, params, AllOrderVO.class);
		return list;
	}
	
	
	public int addAddr(OrderPO order) throws Exception{
		String sql="update orderinfo set addrNo=? where orderNo=? and memberNo=?";
		return db.update(sql, order.getAddrNo(),order.getOrderNo(),order.getMemberNo());
	}
	
}
