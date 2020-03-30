package com.sz.service.impl;

import com.sz.dao.impl.UserBeanDaoImpl;
import com.sz.dao.intf.UserBeanDao;
import com.sz.service.intf.UserBeanService;

public class UserBeanServiceImpl implements UserBeanService{
	
	
	@Override
	public boolean login(String userName, String password) {
		UserBeanDao userDao = new UserBeanDaoImpl();
		return userDao.login(userName, password);
	}

}
