package com.yc.dao;

import java.util.List;

import com.yc.po.MemberPO;

public interface MemberDAO {

	public int addMember(MemberPO po) throws Exception;
	
	public MemberPO Login(MemberPO po) throws Exception;
	
	public List<MemberPO> showMember(Integer pageNum,Integer pagesize) throws Exception;

	public int findByPageTotal() throws Exception;
	
	public int deleteMember(MemberPO po) throws Exception;
	
	public MemberPO findMemberByItem(int MemberNo) throws Exception;
}
