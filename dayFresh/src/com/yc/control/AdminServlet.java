package com.yc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.AdminDAO;
import com.yc.dao.impl.AdminDAOImpl;
import com.yc.po.AdminPO;
import com.yc.util.WebUtil;

@WebServlet("/admin.action")
public class AdminServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3139168731883854014L;
	AdminDAO dao=new AdminDAOImpl();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebUtil.setEncodings(request, response);
		String op=request.getParameter("op");
		if("login".equals(op)){
			doLogin(request,response);
		}else if("modify".equals(op)){
			doModify(request,response);
		}
	}
	
	private void doModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminPO po=parseRequest(request, AdminPO.class);
		
		String oldPwd=request.getParameter("oldPwd");
		String newPwd=request.getParameter("newPwd");
		po.setAdminPwd(newPwd);
		AdminPO admin=(AdminPO) request.getSession().getAttribute("admin");
		if(!oldPwd.equals(admin.getAdminPwd())){
			toPrintJson(response, 0);
		}else{
			try {
				int a=dao.updateAdmin(po);
				toPrintJson(response, a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		AdminPO po=parseRequest(request, AdminPO.class);
		try {
			AdminPO admin=dao.Login(po);
			
			if(null==admin){
				toPrintJson(response, 0);
			}else{
				String adminName=admin.getAdminName();
				request.getSession().setAttribute("admin", admin);
				request.getSession().setAttribute("adminName", adminName);
				request.setAttribute("adminName", adminName);
				toPrintJson(response, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
