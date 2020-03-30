package com.sz.ben.hibernate.demo1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sz.ben.hibernate.utils.HibernateUtils;

/**
 * Hibernate的工具类的测试
 * @author quinnf
 *
 */
public class HibernateDemo2 {

	@Test
	// 保存客户
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer  = new Customer();
		customer.setCust_name("王小西");
		Serializable id = session.save(customer);
		System.out.println(id);
		tx.commit();
		session.close();
	}
	
	@Test
	// 查询：
	// ***** get方法和load方法的区别
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/**
		 * get方法
		 * 	* 采用的是立即加载，执行到这行代码的时候，就会马上发送SQL语句去查询。
		 *  * 查询后返回是真实对象本身。
		 * 	* 查询一个找不到的对象的时候，返回null
		 * 
		 * load方法
		 * 	* 采用的是延迟加载（lazy懒加载），执行到这行代码的时候，不会发送SQL语句，当真正使用这个对象的时候才会发送SQL语句。
		 *  * 查询后返回的是代理对象。javassist-3.18.1-GA.jar 利用javassist技术产生的代理。
		 *  * 查询一个找不到的对象的时候，返回ObjectNotFoundException
		 */
		// 使用get方法查询
		/*Customer customer = session.get(Customer.class, 100l); // 发送SQL语句
		System.out.println(customer);*/
		
		// 使用load方法查询
		Customer customer = session.load(Customer.class, 200l);
		System.out.println(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 修改操作
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 直接创建对象，进行修改
		/*Customer customer = new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("王聪");
		session.update(customer);*/
		
		// 先查询，再修改(推荐)
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_name("王小贱");
		session.update(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 删除操作
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 直接创建对象，删除
	/*	Customer customer = new Customer();
		customer.setCust_id(1l);
		session.delete(customer);*/
		
		// 先查询再删除(推荐)--级联删除
		Customer customer = session.get(Customer.class, 2l);
		session.delete(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 保存或更新
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Customer customer  = new Customer();
		customer.setCust_name("王凤");
		session.saveOrUpdate(customer);*/
		
		Customer customer = new Customer();
		customer.setCust_id(3l);
		customer.setCust_name("李如花");
		session.saveOrUpdate(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 查询所有
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		// 接收HQL：Hibernate Query Language 面向对象的查询语言
		/*Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}*/
		
		// 接收SQL：
		SQLQuery query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		tx.commit();
		session.close();
	}
}
