package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.commons.DbHelper;
import com.yc.dao.OrderDAO;
import com.yc.vo.AllOrderVO;
import com.yc.vo.OrderVO;

public class OrderDAOImpl implements OrderDAO {

	DbHelper db=new DbHelper();
	/**
	 * 查询订单
	 */
	@Override
	public List<OrderVO> findOrder(OrderVO vo) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select orderNo,orderDate,o.addrNo,sdate,rdate,o.status,"
				+ "price,invoice,o.memberNo,name,tel,province,city,area,addr,"
				+ "flag from orderinfo o inner join addrinfo a where o.addrNo=a.addrNo");
		List<Object> params=null;
		if(vo!=null){
			params=new ArrayList<Object>();
			if(vo.getOrderNo()!=null){
				sb.append(" and orderNo=?");
				params.add(vo.getOrderNo());
			}
			if(vo.getStatus()!=null){
				sb.append(" and o.status=?");
				params.add(vo.getStatus());
			}
		}
		sb.append(" order by orderDate asc");	
		return db.findMutil(sb.toString(), params, OrderVO.class);
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<OrderVO> findOrderByPage(OrderVO vo, Integer pageNum, Integer pagesize) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select orderNo,orderDate,o.addrNo,sdate,rdate,o.status,"
				+ "price,invoice,o.memberNo,name,tel,province,city,area,addr,"
				+ "flag from orderinfo o inner join addrinfo a where o.addrNo=a.addrNo");
		List<Object> params=null;
		if(vo!=null){
			params=new ArrayList<Object>();
			if(vo.getOrderNo()!=null){
				sb.append(" and orderNo=?");
				params.add(vo.getOrderNo());
			}
			if(vo.getStatus()!=null){
				sb.append(" and o.status=?");
				params.add(vo.getStatus());
			}
		}
		sb.append(" order by orderDate asc");
		//添加分页的参数
		if(null!=pageNum &&null!=pagesize){
			sb.append(" limit "+(pageNum-1)*pagesize+","+pagesize);
		}
		
		return db.findMutil(sb.toString(), params, OrderVO.class);
	}
	
	@Override
	public int findByPageTotal(OrderVO vo) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) from orderinfo o where 1=1");
		List<Object> params=null;
		if(vo!=null){
			params=new ArrayList<Object>();
			if(vo.getOrderNo()!=null){
				sb.append(" and orderNo=?");
				params.add(vo.getOrderNo());
			}
			if(vo.getStatus()!=null){
				sb.append(" and o.status=?");
				params.add(vo.getStatus());
			}
		}
		return (int) db.getPolymer(sb.toString(), params);
	}
	@Override
	public int updateItem(OrderVO vo) throws Exception {
		String sql="update orderinfo set status=? where orderNo=?";
		return db.update(sql, vo.getStatus(),vo.getOrderNo());
	}
	
	@Override
	public List<List<AllOrderVO>> findOrderByItem(AllOrderVO vo,int memberNo) throws Exception {
		List<List<AllOrderVO>> list=new ArrayList<List<AllOrderVO>>();
		String sql01="select orderNo from orderinfo where memberNo=?";
		List<Object> params01=new ArrayList<Object>();
		params01.add(memberNo);
		List<Map<String,Object>> list01=db.selectMutil(sql01, params01);
		for(Map<String,Object> map:list01){
			String sql02="select orderDate,oi.orderNo orderNo,oi.status status,pictures,goodsName,g.price price,unit,"
					+" nums from orderinfo oi left join orderiteminfo oii on oi.orderNo=oii.orderNo"
					+" left join goodsinfo g on oii.goodsNo=g.goodsNo where oi.orderNo=?";
			List<Object> params02=new ArrayList<Object>();
			params02.add(map.get("orderNo"));
			List<AllOrderVO> list02=db.findMutil(sql02, params02,AllOrderVO.class);
			list.add(list02);
		}
		return list;
	}

}
