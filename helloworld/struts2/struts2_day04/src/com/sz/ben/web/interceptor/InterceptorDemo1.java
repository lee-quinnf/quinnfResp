package com.sz.ben.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义的拦截器一
 * @author quinnf
 *
 */
public class InterceptorDemo1 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("InterceptorDemo1执行了...");
		String obj = invocation.invoke();
		System.out.println("InterceptorDemo1执行结束了...");
		return obj;
	}

}
