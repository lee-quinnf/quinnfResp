package com.ben.crm.service;

import java.util.List;

import com.ben.crm.pojo.BaseDict;

/**
 * 字典数据表业务逻辑接口
 * @author quinnf
 *
 */
public interface BaseDictService {
	/**
	 * 跟据字典编码查询字典列表
	 * @param code
	 * @return
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
