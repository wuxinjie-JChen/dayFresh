package com.yc.dao;

import java.util.List;
import com.yc.po.AddrInfoPO;

public interface AddrInfoDAO {
	
	public List<AddrInfoPO> findAddrByItem(AddrInfoPO addr) throws Exception;

	/**
	 * 修改地址表
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	int updateAddrInfo(AddrInfoPO addrInfo) throws Exception;
}
