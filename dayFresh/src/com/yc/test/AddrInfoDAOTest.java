package com.yc.test;

import org.junit.Test;

import com.yc.dao.AddrInfoDAO;
import com.yc.dao.impl.AddrInfoDAOImpl;
import com.yc.po.AddrInfoPO;

public class AddrInfoDAOTest {
	
	AddrInfoDAO dao=new AddrInfoDAOImpl();
	
	@Test
	public void testupdateAddrInfo(){
		AddrInfoPO addrInfo=new AddrInfoPO();
		addrInfo.setName("刘玉强");
		addrInfo.setTel("17670343098");
		addrInfo.setProvince("湖南省");
		addrInfo.setCity("益阳市");
		addrInfo.setArea("桃江县");
		addrInfo.setAddr("fdadfd");
		addrInfo.setMemberNo(123456);
		try {
			int i=dao.updateAddrInfo(addrInfo);
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
