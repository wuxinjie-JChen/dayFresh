package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.GoodsInfoDAO;
import com.yc.po.GoodsInfoPO;
import com.yc.vo.GoodsVO;

public class GoodsInfoDAOImpl implements GoodsInfoDAO {
	DbHelper db=new DbHelper();
	
	@Override
	public List<GoodsVO> findAll() throws Exception {
		String sql="select goodsNo,goodsName,t.typeNo typeNo,typeName,price,intro,balance,pictures,unit,qperied,weight,descr,picture ,status"
  +" from goodsinfo i , goodstype t  where  i.typeNo=t.typeNo";
		return db.findMutil(sql, null, GoodsVO.class);
	}
	
	@Override
	public List<GoodsVO> findByItem(GoodsVO goods,String typeNo) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select goodsNo,goodsName,t.typeNo typeNo,t.typeName,price,intro,balance,"
		+" pictures,unit,qperied,weight,descr,picture ,status"
		+" from goodsinfo i , goodstype t  where  i.typeNo=t.typeNo");
		List<Object> params=new ArrayList<Object>();
		//System.out.println(typeNo);
		if(goods!=null ){
			if(goods.getGoodsNo()!=null){
				sql.append(" and goodsNo=?");
				params.add(goods.getGoodsNo());
			}
			if(goods.getGoodsName()!=null){
				sql.append(" and goodsName like '%"+goods.getGoodsName()+"%'");
			}
		}else{
			if(typeNo!=null && typeNo.length()>0){
				int no=Integer.parseInt(typeNo);
				sql.append(" and i.typeNo=?");
				params.add(no);
			}
			
		}
		return db.findMutil(sql.toString(), params, GoodsVO.class);
	}
	
	@Override
	public List<GoodsInfoPO> findAllGoods() throws Exception {
		String sql="select goodsNo,goodsName,typeNo,price,intro,balance,pictures,unit,qperied,weight,descr"
				+" from goodsinfo";
		return db.findMutil(sql, null, GoodsInfoPO.class);
	}
	
	/*@Override
	public List<GoodsInfoPO> findAllGoods() throws Exception {
		String sql="select goodsNo,goodsName,typeNo,price,intro,balance,pictures,unit,qperied,weight,descr"
				+" from goodsinfo";
		return db.findMutil(sql, null, GoodsInfoPO.class);
	}*/
}
