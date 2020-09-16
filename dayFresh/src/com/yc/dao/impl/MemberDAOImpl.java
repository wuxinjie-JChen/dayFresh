package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.MemberDAO;
import com.yc.po.MemberPO;

public class MemberDAOImpl implements MemberDAO {

	DbHelper db=new DbHelper();
	/**
	 * 注册
	 */
	@Override
	public int addMember(MemberPO po) throws Exception {
		String sql="insert into memberinfo (meberNo,nickName,pwd,tel,email,regDate) values(null,?,?,?,?,?)";
		return db.update(sql,po.getNickName(),po.getPwd(),po.getTel(),po.getEmail(),po.getRegDate());
	}

	/**
	 * 登陆
	 */
	@Override
	public MemberPO Login(MemberPO po) throws Exception {
		String sql="select meberNo,nickName,pwd,tel,email,regDate from memberinfo where nickName=? and pwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getNickName());
		params.add(po.getPwd());
		return db.findSingle(sql, params, MemberPO.class);
	}

	/**
	 * 所有用户
	 */
	@Override
	public List<MemberPO> showMember(Integer pageNum,Integer pagesize) throws Exception {
		String sql="select meberNo,nickName,pwd,tel,email,regDate from memberinfo"
				+ " order by meberNo asc limit "+(pageNum-1)*pagesize+","+pagesize;
		return db.findMutil(sql, null, MemberPO.class);
	}

	@Override
	public int findByPageTotal() throws Exception {
		String sql="select count(*) from memberinfo";
		return (int) db.getPolymer(sql, null);
	}

	/**
	 * 删除用户
	 */
	@Override
	public int deleteMember(MemberPO po) throws Exception {
		String sql="delete from memberinfo where meberNo=?";
		return db.update(sql, po.getMeberNo());
	}
	
	
	@Override
	public MemberPO findMemberByItem(int MemberNo) throws Exception {
		String sql="select meberNo,nickName,realName,pwd,tel,email,regDate,status from memberinfo"
				+" where meberNo=?";
		List<Object> params=new ArrayList<Object>();
		params.add(MemberNo);
		return db.findSingle(sql, params, MemberPO.class);
	}
}
