package com.yc.dao;

import com.yc.po.AdminPO;

public interface AdminDAO {

	public int addAdmin(AdminPO po) throws Exception;
	
	public AdminPO Login(AdminPO po) throws Exception;
	
	public int updateAdmin(AdminPO po) throws Exception;
}
