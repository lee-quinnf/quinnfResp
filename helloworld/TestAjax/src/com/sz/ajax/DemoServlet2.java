package com.sz.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
			
			request.setCharacterEncoding("UTF-8");
			
			//1. 检测是否存在
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			System.out.println("name="+name+age);
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//	
//			out.write("aaa");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("收到了请求...");
			//out.println(111);
//			UserDao dao = new UserDaomImpl();
//			boolean isExist = dao.checkUserName(name);
			
			//2.  通知页面，到底有还是没有。
//			if(isExist){
//				response.getWriter().println(1);  //存在用户名
//			}else{
//				response.getWriter().println(2); //不存在该用户名
//			}
			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	 
}
