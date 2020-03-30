package com.sz.ben.mybatis.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sz.ben.mybatis.mapper.UserMapper;
import com.sz.ben.mybatis.pojo.User;
import com.sz.ben.mybatis.pojo.UserExample;

public class JunitTest {

	
	@Test
	public void testMapper() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example = new UserExample();
		String username = "明";
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%" + username + "%");
		
		example.setOrderByClause("id desc");
		
		int countByExample = userMapper.countByExample(example);
		System.out.println(countByExample);
		
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user);
		
		
		List<User> users = userMapper.selectByExample(example);
		for (User user2 : users) {
			System.out.println(user2.getId());
		}
		
		
		
		
	}
}
