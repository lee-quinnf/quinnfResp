package com.sz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sz.model.Student;
import com.sz.service.impl.StudentServiceImpl;
import com.sz.service.impl.UserBeanServiceImpl;
import com.sz.service.intf.StudentService;
import com.sz.service.intf.UserBeanService;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello login servlet GET");
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserBeanService userService = new UserBeanServiceImpl();
		
		boolean isSuccess = userService.login(userName, password);
		
		if (isSuccess) {
			resp.getWriter().write("login success, show list");
			System.out.println("login success, show list");
			StudentService studentService = new StudentServiceImpl();
			List<Student> list = studentService.findAll();
			
			req.getSession().setAttribute("list", list);
			resp.sendRedirect("stu_list.jsp");
			
		} else {
			resp.getWriter().write("login fail, please try again");
			//resp.sendRedirect("login.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello login servlet POST");
		doGet(req, resp);
		
		
	}
}
