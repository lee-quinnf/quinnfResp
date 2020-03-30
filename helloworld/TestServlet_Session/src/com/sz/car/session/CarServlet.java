package com.sz.car.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

public class CarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello car servlet GET");
		int id = Integer.parseInt(req.getParameter("id"));
		String [] names = {"Iphone7","小米6","三星Note8","魅族7" , "华为9"};//可以从数据库取
		String name = names[id];
		
		HttpSession session = req.getSession();
		Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");

		
		if (map == null) {
			map = new LinkedHashMap<String, Integer>();
			map.put(name, 1);
			session.setAttribute("cart", map);
		} else {
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
			
		}
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("<a href='product_list.jsp'><h3>继续购物</h3></a><br>");
		resp.getWriter().write("<a href='cart.jsp'><h3>去购物车结算</h3></a>");
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello car servlet POST");
		doGet(req, resp);
		
		
	}
}
