package com.yc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取资源请求路径
        String requestURI = request.getRequestURI();
        //System.out.println(requestURI);
        //排除包含登录确实所需要的资源，给予放行
        if (requestURI.contains("/cart.jsp") || requestURI.contains("/order.jsp") || requestURI.contains("/user.jsp") || requestURI.contains("/details.jsp")) {
        	//不包含，即验证用户是否已经登录
            Object user = request.getSession().getAttribute("member");
            if (user != null){
                //登陆了，放行
                chain.doFilter(request,response);
            }else{
                //没有登录，跳转回登录页面
            	response.sendRedirect("/dayFresh/login.jsp");
                //request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
        	chain.doFilter(request,response);
        }

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
