package com.yc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

public class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5457887926777893383L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	/**
	 * 解析请求对象
	 * @param request
	 * @param cls
	 * @return
	 */
	public <T> T parseRequest(HttpServletRequest request,Class<T> cls){
		T t=null;
		//获取cls字段
		Field []fields=cls.getDeclaredFields();
		Method []methods=cls.getDeclaredMethods();
		//根据反射创建实例对象
		try{
			t=cls.newInstance();
			//循环该对象的所有字段
			for(Field f:fields){
				String fname=f.getName();
				//根据当前这个名称从请求对象中获取值
				String value=request.getParameter(fname);
				if(null==value || "".equals(value)){
					continue;
				}
				//循环方法，找到与之匹配的set方法，进行激活赋值
				for(Method m: methods){
					if(("set"+fname).equalsIgnoreCase(m.getName())){
						//获取set方法形参数据类型 set 仅有一个参数
						String typeName=m.getParameterTypes()[0].getName();
						if("java.lang.Integer".equals(typeName)){
							m.invoke(t,Integer.parseInt(value));
						}else if("java.lang.Double".equals(typeName)){
							m.invoke(t,Double.parseDouble(value));
						}else if("java.lang.Float".equals(typeName)){
							m.invoke(t,Float.parseFloat(value));
						}else if("java.lang.Long".equals(typeName)){
							m.invoke(t,Long.parseLong(value));
						}else{
							m.invoke(t,value);
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return t;
	}
	
	
	/** 
	 * 输出整数
	 * @param response
	 * @param i
	 * @throws IOException
	 */
	public void toPrintJson(HttpServletResponse response,Integer i) throws IOException{
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		out.print(gson.toJson(i));
	}
	
	
	public void toPrintJson(HttpServletResponse response,Object obj,Integer total) throws IOException{
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"total\":"+total);
		sb.append(",\"rows\":"+gson.toJson(obj));
		sb.append("}");
		out.print(sb.toString());
	}
	
	/**
	 * 输出字符串
	 * @param response
	 * @param str
	 * @throws IOException
	 */
	public void toPrintJson(HttpServletResponse response,String str) throws IOException{
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		out.print(gson.toJson(str));
	}
	
	public void toPrintJson(HttpServletResponse response,Object obj) throws IOException{
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		out.print(gson.toJson(obj));
	}
}
