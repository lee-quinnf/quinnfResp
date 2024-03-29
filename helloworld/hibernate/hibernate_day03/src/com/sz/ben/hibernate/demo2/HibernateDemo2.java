package com.sz.ben.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sz.ben.hibernate.domain.Role;
import com.sz.ben.hibernate.domain.User;
import com.sz.ben.hibernate.utils.HibernateUtils;

/**
 * Hibernate的多对多的映射
 * @author quinnf
 *
 */
public class HibernateDemo2 {

	@Test
	/**
	 * 保存多条记录：保存多个用户和角色
	 */
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 创建2个用户
		User user1 = new User();
		user1.setUser_name("赵洪");
		User user2 = new User();
		user2.setUser_name("李兵");
		
		// 创建3个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		Role role2 = new Role();
		role2.setRole_name("市场部");
		Role role3 = new Role();
		role3.setRole_name("公关部");
		
		// 设置双向的关联关系:
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user2);
		
		// 保存操作:多对多建立了双向的关系必须有一方放弃外键维护。
		// 一般是被动方放弃外键维护权。
		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		session.save(role3);
		
		tx.commit();
	}
	
	@Test
	/**
	 * 多对多的操作：
	 * * 只保存一边是否可以？不可以，瞬时对象异常
	 */
	public void demo2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 创建2个用户
		User user1 = new User();
		user1.setUser_name("赵洪");
		
		// 创建3个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		
		// 设置双向的关联关系:
		user1.getRoles().add(role1);
		role1.getUsers().add(user1);
		// 只保存用户：
		// session.save(user1);
		session.save(role1);
		
		tx.commit();
	}
	
	@Test
	/**
	 * 多对多的级联保存：
	 * * 保存用户级联保存角色。在用户的映射文件中配置。
	 * * 在User.hbm.xml中的set上配置 cascade="save-update"
	 */
	public void demo3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 创建2个用户
		User user1 = new User();
		user1.setUser_name("赵洪");
		
		// 创建3个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		
		// 设置双向的关联关系:
		user1.getRoles().add(role1);
		role1.getUsers().add(user1);
		// 只保存用户：
		session.save(user1);
		
		tx.commit();
	}
	
	/**
	 * 多对多的级联保存：
	 * * 保存角色级联保存用户。在角色的映射文件中配置。
	 * * 在Role.hbm.xml中的set上配置 cascade="save-update"
	 */
	@Test
	public void demo4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 创建2个用户
		User user1 = new User();
		user1.setUser_name("李兵");
		
		// 创建3个角色
		Role role1 = new Role();
		role1.setRole_name("公关部");
		
		// 设置双向的关联关系:
		user1.getRoles().add(role1);
		role1.getUsers().add(user1);
		// 只保存用户：
		session.save(role1);
		
		tx.commit();
	}
	
	/**
	 * 多对多的级联删除：
	 * * 删除用户级联删除角色
	 * * 在User.hbm.xml中的set上配置 cascade="delete"
	 */
	@Test
	public void demo5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 查询1号用户:
		User user  = session.get(User.class, 1l);
		session.delete(user);
		
		tx.commit();
	}
	
	/**
	 * 多对多的级联删除：
	 * * 删除角色级联删除用户
	 * * 在Role.hbm.xml中的set上配置 cascade="delete"
	 */
	@Test
	public void demo6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 查询2号角色:
		Role role  = session.get(Role.class, 2l);
		session.delete(role);
		
		tx.commit();
	}
	
	@Test
	/**
	 * 给用户选择角色
	 */
	public void demo7(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 给1号用户多选2号角色
		// 查询1号用户
		User user  = session.get(User.class, 1l);
		// 查询2号角色
		Role role = session.get(Role.class, 2l);
		user.getRoles().add(role);
		
		tx.commit();
	}
	
	@Test
	/**
	 * 给用户改选角色
	 */
	public void demo8(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 给2号用户将原有的2号角色改为3号角色
		// 查询2号用户
		User user  = session.get(User.class, 2l);
		// 查询2号角色
		Role role2 = session.get(Role.class, 2l);
		Role role3 = session.get(Role.class, 3l);
		user.getRoles().remove(role2);
		user.getRoles().add(role3);
		
		tx.commit();
	}
	
	@Test
	/**
	 * 给用户改选角色
	 */
	public void demo9(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 给2号用户删除1号角色
		// 查询2号用户
		User user  = session.get(User.class, 2l);
		// 查询2号角色
		Role role = session.get(Role.class, 1l);
		user.getRoles().remove(role);
		
		tx.commit();
	}
}
