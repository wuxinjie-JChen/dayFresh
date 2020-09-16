package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.GoodsDAO;
import com.yc.po.GoodsPO;

public class GoodsDAOImpl implements GoodsDAO {

	DbHelper db=new DbHelper();
	/**
	 * 添加
	 */
	@Override
	public int addGoods(GoodsPO po) throws Exception {
		String sql="insert into goodsinfo value(null,?,?,?,?,?,?,?,?,?,?)";
		return db.update(sql, po.getGoodsName(),po.getTypeNo(),po.getPrice(),po.getIntro(),
				po.getBalance(),po.getPictures(),po.getUnit(),po.getQperied(),
				po.getWeight(),po.getDescr());
	}

	/**
	 * 查询
	 */
	@Override
	public List<GoodsPO> findByTremGoods(GoodsPO po) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select goodsNo,goodsName,g.typeNO,typeName,price,intro,balance,pictures,unit,qperied,"
				+ " weight,descr from goodsinfo g inner join goodstype t where g.typeNo=t.typeNo ");
		List<Object> params=null;
		if(po!=null){
			params=new ArrayList<Object>();
			if(po.getGoodsNo()!=null){
				sb.append(" and goodsNo=?");
				params.add(po.getGoodsNo());
			}
			if(po.getTypeNo()!=null){
				sb.append(" and typeNo=?");
				params.add(po.getTypeNo());
			}
			if(po.getGoodsName()!=null){
				sb.append(" and goodsName like '%"+po.getGoodsName()+"%'");
			}
			
		}
		sb.append(" order by goodsNo asc");
		return db.findMutil(sb.toString(), params, GoodsPO.class);
	}
	
	@Override
	public List<GoodsPO> findByPage(GoodsPO po, Integer pageNum, Integer pagesize) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select goodsNo,goodsName,g.typeNO,typeName,price,intro,"
				+ "balance,pictures,unit,qperied,weight,descr from goodsinfo g"
				+ " inner join goodstype t where g.typeNo=t.typeNo");
		List<Object> params=null;
		if(po!=null){
			params=new ArrayList<Object>();
			if(po.getTypeNo()!=null){
				sb.append(" and g.typeNo=?");
				params.add(po.getTypeNo());
			}
			if(po.getGoodsName()!=null){
				sb.append(" and goodsName like '%"+po.getGoodsName()+"%'");
			}	
		}
		sb.append(" order by goodsNo asc");
		//添加分页的参数
		if(null!=pageNum &&null!=pagesize){
			sb.append(" limit "+(pageNum-1)*pagesize+","+pagesize);
		}
		return db.findMutil(sb.toString(), params, GoodsPO.class);
	}
	@Override
	public int findByPageTotal(GoodsPO po) throws Exception {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(*) from goodsinfo where 1=1");
		List<Object> params=null;
		if(null!=po){
			params=new ArrayList<Object>();
			if(po.getTypeNo()!=null){
				sb.append(" and typeNo=?");
				params.add(po.getTypeNo());
			}
			if(po.getGoodsName()!=null){
				sb.append(" and goodsName like '%"+po.getGoodsName()+"%'");
			}
		}
		return (int) db.getPolymer(sb.toString(), params);
	}

	/**
	 * 修改
	 */
	@Override
	public int modifyGoodsPO(GoodsPO po) throws Exception {
		String sql="update goodsinfo set goodsName=?,typeNO=?,price=?,intro=?,balance=?,pictures=?,unit=?,qperied=?,"
				+ " weight=?,descr=? where goodsNo=?";
		return db.update(sql, po.getGoodsName(),po.getTypeNo(),po.getPrice(),po.getIntro(),
				po.getBalance(),po.getPictures(),po.getUnit(),po.getQperied(),
				po.getWeight(),po.getDescr(),po.getGoodsNo());
	}

	@Override
	public int deleteGoods(GoodsPO po) throws Exception {
		String sql="delete from goodsinfo where goodsNo=?";
		return db.update(sql, po.getGoodsNo());
	}

}
