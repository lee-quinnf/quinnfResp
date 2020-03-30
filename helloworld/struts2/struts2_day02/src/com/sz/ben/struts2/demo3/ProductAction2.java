package com.sz.ben.struts2.demo3;

import java.util.Map;

import com.itheima.struts2.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 复杂数据类型的封装：封装到Map集合
 * @author quinnf
 *
 */
public class ProductAction2 extends ActionSupport {

	private Map<String,Product> map;
	
	public Map<String, Product> getMap() {
		return map;
	}

	public void setMap(Map<String, Product> map) {
		this.map = map;
	}

	@Override
	public String execute() throws Exception {
		for (String key : map.keySet()) {
			Product product = map.get(key);
			System.out.println(key+"    "+product);
		}
		return NONE;
	}
}
