package com.sz.login;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//last time login 
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello servlet GET");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		if ("admin".equals(userName) && "111".equals(password)) {
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				Cookie cookie = findCookie(cookies);
				if (cookie != null) {
					long lastVistTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastVistTime);
					resp.getWriter().write("last login time is : " + cookie.getValue() + 
							" " + date);
					cookie.setValue(System.currentTimeMillis() + "");
					resp.addCookie(cookie);
				} else {
					Cookie newCookie = addCookie(resp);
					long lastVistTime = Long.parseLong(newCookie.getValue());
					Date date = new Date(lastVistTime);
					resp.getWriter().write("first time login is : " + newCookie.getValue() + date);
					System.out.println("first time login " + newCookie.getValue() +" " 
							+ date);
				}
			} else {
				System.out.println("cookie is null");
				//resp.getWriter().write("cookie is null");
				addCookie(resp);
			}
			
		} else {
			System.out.println("wrongly username or password");
			resp.getWriter().write("login fail, please try again");
		}
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello servlet POST");
		doGet(req, resp);
		
		
	}
	
	
	public Cookie addCookie(HttpServletResponse resp) {
		long visitTime = System.currentTimeMillis();
		Cookie cookie = new Cookie("last", visitTime + "");
		cookie.setMaxAge(60*60*1);
		resp.addCookie(cookie);
		System.out.println("add cookie");
		return cookie;
		
	}
	
	public Cookie addUserAccountCookie(HttpServletResponse resp) {
		Cookie cookie = new Cookie("last", "benjiamin");
		cookie.setMaxAge(60*60*1);
		resp.addCookie(cookie);
		System.out.println("add cookie");
		return cookie;
		
	}
	
	public Cookie findCookie(Cookie[] cookies) {
		Cookie cookie = null;
		for (Cookie c : cookies) {
			String cookieName = c.getName();
			if ("last".equals(cookieName)) {
				System.out.println("last login time : " + c.getValue());
				cookie = c;
			}
		}
		
		return cookie;
	}
}
