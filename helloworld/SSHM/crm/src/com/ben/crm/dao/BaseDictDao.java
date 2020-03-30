package com.ben.crm.dao;

import java.util.List;

import com.ben.crm.domain.BaseDict;

/**
 * 字典DAO的接口
 * @author quinnf
 *
 */
public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

}
