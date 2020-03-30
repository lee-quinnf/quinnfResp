package com.sz.servlet.login.auto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sz.bean.UserBean;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession();
		System.out.println("hello Loginservlet GET");
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String autoLogin = req.getParameter("auto_login");
		
		UserBean user = new UserBean();
		user.setUsername(userName);
		user.setPassword(password);
//		UserDao dao = new UserDaoImpl();
//		UserBean userBean = dao.login(user);
		UserBean userBean = user;
		
		if(userBean != null){
			
			//页面提交上来的时候，是否选择了自动登录
			if("on".equals(autoLogin)){
				
				//发送cookie给客户端
				System.out.println("autologin");
				Cookie cookie = new Cookie("auto_login", userName+"#quinnf#"+password);
				cookie.setMaxAge(60*60*24*7);//7天有效期
				cookie.setPath("/AutoLoginDemo");
				//cookie.setPath(request.getContextPath());
				resp.addCookie(cookie);
				
			} else {
				Cookie cookie = new Cookie("auto_login", "");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
			
			//成功了，进入首页
			req.getSession().setAttribute("userBean", userBean);
			resp.sendRedirect("index.jsp");
		}else{
			//不成功...
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello Loginservlet POST");
		doGet(req, resp);
		
		
	}
}
