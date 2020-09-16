package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yc.commons.DbHelper;
import com.yc.control.CartInfoServlet;
import com.yc.dao.CartInfoDAO;
import com.yc.vo.CartInfoVO;

public class CartInfoDAOImpl implements CartInfoDAO{
	
	DbHelper db=new DbHelper();
	private static Logger logger = Logger.getLogger(CartInfoDAOImpl.class);
	
	@Override
	public List<CartInfoVO> findAll(int memberNo) throws Exception {
		String sql="select g.goodsNo,goodsName,price,pictures,unit,"
				+ " cartNo,num from goodsinfo g,cartinfo c where g.goodsNo=c.goodsNo"
				+ " and memberNo=?";
		List<Object> params=new ArrayList<Object>();
		params.add(memberNo);
		return db.findMutil(sql, params, CartInfoVO.class);
	}
	
	@Override
	public List<CartInfoVO> findByItem(int memberNo,int goodsNo) throws Exception {
		String sql="select goodsNo,cartNo,num from cartinfo where memberNo=?"
				+ " and goodsNo=?";
		List<Object> params=new ArrayList<Object>();
		params.add(memberNo);
		params.add(goodsNo);
		return db.findMutil(sql, params, CartInfoVO.class);
	}
	
	@Override
	public int addCart(String op,int memberNo,int goodsNo,int nums) throws Exception {
		logger.info("op"+op+"memberNo£º"+memberNo+"goodsNo:"+goodsNo+"nums:"+nums);
		List<CartInfoVO> list=findByItem(memberNo, goodsNo);
		String sql="";
		logger.info(nums+"***********");
		if(list==null || list.size()<=0){
			sql="insert into cartinfo values(null,?,?,?)";
			return db.update(sql, memberNo,goodsNo,nums);
		}else{
			if(op==null || op.equals("add") ){
				sql="update cartinfo set num=num+1 where memberNo=? and goodsNo=?";
			}else if(op.equals("all")){
				sql="update cartinfo set num=num+? where memberNo=? and goodsNo=?";
				return db.update(sql,nums, memberNo,goodsNo);
			}else/*(op.equals("minus"))*/{
				sql="update cartinfo set num=num-1 where memberNo=? and goodsNo=?";
			}
		}
		return db.update(sql, memberNo,goodsNo);
	}

	@Override
	public int delgoods(int memberNo, int goodsNo) throws Exception {
		String sql="delete from cartinfo where memberNo=? and goodsNo=?";
		return db.update(sql, memberNo,goodsNo);
	}
	
}
