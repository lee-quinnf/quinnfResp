package com.ben.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ben.crm.domain.BaseDict;
import com.ben.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 字典的Action的类
 * @author quinnf
 *
 */
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	// 模型驱动使用的对象
	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}

	// 注入Service
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
	/**
	 * 根据类型名称查询字典的方法:findByTypeCode
	 * @throws IOException 
	 */
	public String findByTypeCode() throws IOException{
		System.out.println("BaseDictAction中的findByTypeCode方法执行了....");
		// 调用业务层查询:
		List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		// 将list转成JSON.---- jsonlib  fastjson
		/**
		 * JSONConfig：转JSON的配置对象
		 * JSONArray ：将数组和list集合转成JSON
		 * JSONObject：将对象和Map集合转成JSON
		 */
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		System.out.println(jsonArray.toString());
		// 将JSON打印到页面:
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
}
