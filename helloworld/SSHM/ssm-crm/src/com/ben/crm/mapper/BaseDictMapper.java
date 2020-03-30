package com.ben.crm.mapper;

import java.util.List;

import com.ben.crm.pojo.BaseDict;

/**
 * 字典数据表持久化接口
 * @author quinnf
 *
 */
public interface BaseDictMapper {
	/**
	 * 跟据字典编码查询字典列表
	 * @param code
	 * @return
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
