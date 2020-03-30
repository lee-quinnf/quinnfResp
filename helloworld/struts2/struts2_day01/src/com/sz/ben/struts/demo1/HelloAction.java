package com.sz.ben.struts.demo1;
/**
 * Struts2的入门的Action类
 * @author quinnf
 */
public class HelloAction {

	/**
	 * 提供一个方法：
	 *  * 方法签名固定的
	 *  共有的 返回值是String类型 方法名execute 在这个方法中不能传递参数。
	 */
	public String execute(){
		System.out.println("HelloAction执行了...");
		return "success";
	}
}
