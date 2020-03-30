package com.sz.cookie.hist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sz.cookie.util.CookieUtil;

public class HistoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello Historyservlet GET");
		
		String id = req.getParameter("id");
		Cookie[] cookies = req.getCookies();
		Cookie cookie = CookieUtil.findCookie(cookies, "history");
		if (cookie == null) {
			cookie = new Cookie("history", id);
			cookie.setMaxAge(60*60);
		} else {
			String value = cookie.getValue() + "#" + id;
			cookie.setValue(value);
			cookie.setMaxAge(60*60);
		}
//		Cookie cookies = new Cookie("history", id + "#");
		resp.addCookie(cookie);
		resp.sendRedirect("product_info.htm");
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello Historyservlet POST");
		doGet(req, resp);
		
		
	}
}
