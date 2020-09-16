package com.yc.test;

import java.util.List;
import org.junit.Test;
import com.yc.dao.MemberDAO;
import com.yc.dao.impl.MemberDAOImpl;
import com.yc.po.MemberPO;

public class MemberDAOTest {

	MemberDAO dao=new MemberDAOImpl();
	@Test
	public void testAddMember() throws Exception {
		MemberPO po=new MemberPO();
		po.setNickName("yccv");
		po.setPwd("a");
		po.setTel("133");
		//po.setRegDate("2019-08-13");
		po.setEmail("122@qq.com");
		int a=dao.addMember(po);
	}
	
	

	@Test
	public void testLogin() throws Exception {
		MemberPO po=new MemberPO();
		po.setNickName("yc");
		po.setPwd("a");
		MemberPO member=dao.Login(po);
		System.out.println(member.getNickName()+"--"+member.getEmail()+"--"+member.getPwd());
	}
	
	@Test
	public void testShowUser() throws Exception {
		List<MemberPO> list=dao.showMember(1,2);
		for(MemberPO m:list){
			System.out.println(m.getNickName());
		}
	}
	
	
	@Test
	public void testFindMemberByItem() throws Exception {
		MemberPO a=dao.findMemberByItem(123456);
		System.out.println(a.getNickName());
	}

}
