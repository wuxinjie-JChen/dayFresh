package com.yc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.AddrInfoDAO;
import com.yc.dao.impl.AddrInfoDAOImpl;
import com.yc.po.AddrInfoPO;
import com.yc.po.MemberPO;
import com.yc.util.getPost;

@WebServlet("/addr.action")
public class AddrInfoServlet extends BaseServlet{

	AddrInfoDAO dao=new AddrInfoDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 4452124591215517576L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost.setCharacter(request, response);
		String addrOption=request.getParameter("addrOption");
		if(addrOption.equals("findAddrInfo")){
			dofindAddrInfo(request,response);
		}else if(addrOption.equals("updateInfo")){
			doUpdateInfo(request,response);
		}
	}

	private void doUpdateInfo(HttpServletRequest request, HttpServletResponse response) {
		AddrInfoPO addrInfo=new AddrInfoPO();
		MemberPO memberPO=(MemberPO)request.getSession().getAttribute("member");
		addrInfo.setName(request.getParameter("name"));
		addrInfo.setTel(request.getParameter("tel"));
		addrInfo.setProvince(request.getParameter("province"));
		addrInfo.setCity(request.getParameter("city"));
		addrInfo.setArea(request.getParameter("area"));
		addrInfo.setAddr(request.getParameter("addr"));
		addrInfo.setMemberNo(memberPO.getMeberNo());
		System.out.println(memberPO+"--"+memberPO.getMeberNo());
		try {
			int i=dao.updateAddrInfo(addrInfo);
			System.out.println(i);
			toPrintJson(response, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dofindAddrInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			MemberPO memberPO=(MemberPO)request.getSession().getAttribute("member");
			AddrInfoPO addr=new AddrInfoPO();
			addr.setMemberNo(memberPO.getMeberNo());
			toPrintJson(response, dao.findAddrByItem(addr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
