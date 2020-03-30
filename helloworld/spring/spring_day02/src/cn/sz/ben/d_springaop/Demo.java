package cn.sz.ben.d_springaop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sz.ben.bean.User;
import cn.sz.ben.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/sz/ben/d_springaop/applicationContext.xml")
public class Demo {
	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun1(){
		us.save();
	}
	
}
