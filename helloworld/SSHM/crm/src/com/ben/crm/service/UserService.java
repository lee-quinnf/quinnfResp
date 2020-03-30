package com.ben.crm.service;

import java.util.List;

import com.ben.crm.domain.User;

/**
 * 用户管理的Service的接口
 * @author quinnf
 *
 */
public interface UserService {

	void regist(User user);

	User login(User user);

	List<User> findAll();

}
