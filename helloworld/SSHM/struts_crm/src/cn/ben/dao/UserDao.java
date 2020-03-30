package cn.ben.dao;

import cn.ben.domain.User;

public interface UserDao {
	//根据登陆名返回User
	User getByUserCode(String user_code);

}
