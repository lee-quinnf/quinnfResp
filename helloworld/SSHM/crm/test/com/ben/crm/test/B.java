package com.ben.crm.test;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B extends A{

	public B() {
		
	}
	
	public static void main(String[] args) {
		B b = new B();
		b.a();
	}
	
}

