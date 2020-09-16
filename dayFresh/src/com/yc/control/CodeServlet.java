package com.yc.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.util.VerifyCodeUtils;

@WebServlet("/code.action")
public class CodeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -275901483331335468L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String verifyCode=null;
		
		
		//随机生成验证码
		verifyCode=VerifyCodeUtils.outputImage(response);
		//将验证码添加到会话中  主要，在会话中保存的验证码的名称vcode
		request.getSession().setAttribute("vcode", verifyCode);
		
		
	}

	
}
