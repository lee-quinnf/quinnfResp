package com.ben.crm.dao;

import com.ben.crm.domain.User;

/**
 * 用户管理的DAO的接口
 * @author quinnf
 *
 */
public interface UserDao extends BaseDao<User>{

	User login(User user);

}
