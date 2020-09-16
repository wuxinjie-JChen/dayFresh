package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.yc.commons.DbHelper;
import com.yc.dao.AddrInfoDAO;
import com.yc.po.AddrInfoPO;

public class AddrInfoDAOImpl implements AddrInfoDAO{

	DbHelper db=new DbHelper();
	@Override
	public List<AddrInfoPO> findAddrByItem(AddrInfoPO addr) throws Exception {
		String sql="select addrNo,memberNo,name,tel,province,city,"
				+" area,addr,flag,status from addrinfo where memberNo=? and status=0";
		List<Object> params=new ArrayList<Object>();
		params.add(addr.getMemberNo());
		return db.findMutil(sql, params, AddrInfoPO.class);
	}
	
	@Override
	public int updateAddrInfo(AddrInfoPO addrInfo) throws Exception {
		//String sql01="select memberNo from addrinfo where memberNo=?";
		List<AddrInfoPO> list=findAddrByItem(addrInfo);
		//System.out.println(list.size()+"....");
		String sql="";
		if(list==null || list.size()<=0){
			sql="insert into addrinfo values(null,?,?,?,?,?,?,?,0,0)";
			return db.update(sql,addrInfo.getMemberNo(), addrInfo.getName(),addrInfo.getTel(),
					addrInfo.getProvince(),addrInfo.getCity(),addrInfo.getArea(),
					addrInfo.getAddr());
		}else{
			sql="update addrinfo set name=?,tel=?,province=?,city=?,area=?,"
					+" addr=? where memberNo=?";
			return db.update(sql, addrInfo.getName(),addrInfo.getTel(),
					addrInfo.getProvince(),addrInfo.getCity(),addrInfo.getArea(),
					addrInfo.getAddr(),addrInfo.getMemberNo());
		}
		
		//List<Object> params=new ArrayList<Object>();
		/*return db.update(sql, addrInfo.getName(),addrInfo.getTel(),
				addrInfo.getProvince(),addrInfo.getCity(),addrInfo.getArea(),
				addrInfo.getAddr(),addrInfo.getMemberNo());*/
	}
	
}
