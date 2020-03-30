package com.ben.crm.service;

import java.util.List;

import com.ben.crm.domain.BaseDict;

/**
 * 字典的业务层的接口
 * @author quinnf
 *
 */
public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
