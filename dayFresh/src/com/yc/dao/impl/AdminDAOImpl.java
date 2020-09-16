package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.yc.commons.DbHelper;
import com.yc.dao.AdminDAO;
import com.yc.po.AdminPO;

public class AdminDAOImpl implements AdminDAO {

	DbHelper db=new DbHelper();
	@Override
	public int addAdmin(AdminPO po) throws Exception {
		String sql="insert into admininfo values(null,?,?,?)";
		return db.update(sql, po.getAdminName(),po.getAdminPwd(),po.getAdminTel());
	}

	@Override
	public AdminPO Login(AdminPO po) throws Exception {
		String sql="select adminId,adminName,adminPwd,adminTel from admininfo where adminName=? and adminPwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAdminName());
		params.add(po.getAdminPwd());
		return db.findSingle(sql, params, AdminPO.class);
	}

	@Override
	public int updateAdmin(AdminPO po) throws Exception {
		String sql="update admininfo set adminPwd=? where adminName=?";
		return db.update(sql,po.getAdminPwd(),po.getAdminName());
	}

}
