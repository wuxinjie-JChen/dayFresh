package com.yc.test;

import org.junit.Test;
import com.yc.dao.AdminDAO;
import com.yc.dao.impl.AdminDAOImpl;
import com.yc.po.AdminPO;

public class AdminDAOTest {

	AdminDAO dao=new AdminDAOImpl();
	@Test
	public void testAddAdmin() {
		AdminPO po=new AdminPO();
		po.setAdminName("a");
		po.setAdminPwd("a");
		po.setAdminTel("111");
		try {
			int a=dao.addAdmin(po);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLogin() {
		AdminPO po=new AdminPO();
		po.setAdminName("a");
		po.setAdminPwd("a");
		try {
			AdminPO admin=dao.Login(po);
			System.out.println(admin.getAdminName()+"-"+admin.getAdminTel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
