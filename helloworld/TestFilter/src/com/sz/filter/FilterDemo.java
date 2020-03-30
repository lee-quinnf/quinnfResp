package com.sz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo implements Filter{

	@Override
	public void destroy() {
		System.out.println("filter destroy");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("do filter before");
		chain.doFilter(req, resp);
		System.out.println("do filter after");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter init");
		
	}

}
