package com.sz.cookie.hist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearHistoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello ClearHistoryservlet GET");
		Cookie cookie = new Cookie("history", "");
		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		resp.sendRedirect("product_list.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello ClearHistoryservlet POST");
		doGet(req, resp);
		
		
	}
}
