package com.yc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/codes.action")
public class TestCodeServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4278344053936261083L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String yzm=request.getParameter("yzm");
		String vcode=(String) request.getSession().getAttribute("vcode");
		int a;
		if(yzm.equalsIgnoreCase(vcode)){
			a=1;
		}else{
			a=2;
		}
		toPrintJson(response, a);
	}

}
