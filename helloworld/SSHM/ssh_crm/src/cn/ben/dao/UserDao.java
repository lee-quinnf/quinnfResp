package cn.ben.dao;

import cn.ben.domain.User;

public interface UserDao {
	
	//根据登陆名称查询user对象
	User getByUserCode(String usercode);
	//保存用户
	void save(User u);
}
