package com.yc.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.dao.MemberDAO;
import com.yc.dao.impl.MemberDAOImpl;
import com.yc.po.MemberPO;
import com.yc.util.StringUtil;
import com.yc.util.getPost;
@WebServlet("/member.action")
public class MemberServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8903966676864996928L;
	
	MemberDAO dao=new MemberDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getPost.setCharacter(request, response);
		String op=request.getParameter("op");
		if(op.equals("login")){
			doLogin(request,response);
		}else if(op.equals("register")){
			doRegister(request,response);
		}else if(op.equals("showUser")){
			doShowUser(request,response);
		}else if(op.equals("deleteMember")){
			doDeleteMember(request,response);
		}else if(op.equals("findMemberInfo")){
			dofindMemberInfo(request,response);
		}
		
	}

	/**
	 * 查询登录的用户信息
	 * @param request
	 * @param response
	 */
	private void dofindMemberInfo(HttpServletRequest request, HttpServletResponse response) {
		MemberPO memberPO=(MemberPO)request.getSession().getAttribute("member");
		try {
			if(memberPO==null){
				response.sendRedirect("login.jsp");
				return;
			}
			MemberPO member=dao.findMemberByItem(memberPO.getMeberNo());
			toPrintJson(response, member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void doDeleteMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		MemberPO po=parseRequest(request, MemberPO.class);
		try {
			int a=dao.deleteMember(po);
			toPrintJson(response, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doShowUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagestr=request.getParameter("page");
		String rowStr=request.getParameter("rows");
		try {
			int total=dao.findByPageTotal();
			List<MemberPO> list=null;
			if(StringUtil.isNotNull(rowStr)&&StringUtil.isNotNull(pagestr)){
				list=dao.showMember( Integer.parseInt(pagestr), Integer.parseInt(rowStr));
				toPrintJson(response, list,total);
			}else{
				list=dao.showMember(null, null);
				toPrintJson(response, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		MemberPO po=parseRequest(request, MemberPO.class);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String regDate=sdf.format(date);
		po.setRegDate(regDate);
		try {
			int a=dao.addMember(po);
			toPrintJson(response, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		MemberPO po=parseRequest(request, MemberPO.class);
		try {
			MemberPO member=dao.Login(po);
			if(member!=null){
				request.getSession().setAttribute("member", member);
				request.getSession().setAttribute("memberName", member.getNickName());
			}
			toPrintJson(response, member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
