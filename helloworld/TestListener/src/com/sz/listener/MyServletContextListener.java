package com.sz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("listener-- ServletContext destroy");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("listener-- ServletContext initial");
		
	}

	

}
