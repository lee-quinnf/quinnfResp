package com.sz.ben.hibernate.demo1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.sz.ben.hibernate.domain.Customer;
import com.sz.ben.hibernate.domain.LinkMan;
import com.sz.ben.hibernate.utils.HibernateUtils;

/**
 * QBC的查询
 * @author quinnf
 *
 */
public class HibernateDemo2 {

	@Test
	/**
	 * 简单的查询
	 */
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 获得Criteria的对象
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
	}
	
	@Test
	/**
	 * 排序查询
	 */
	public void demo2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 排序查询
		Criteria criteria = session.createCriteria(Customer.class);
//		criteria.addOrder(Order.asc("cust_id")); // 升序
		criteria.addOrder(Order.desc("cust_id")); // 降序
		List<Customer> list = criteria.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	@Test
	/**
	 * 分页查询
	 */
	public void demo3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 分页查询
		Criteria criteria = session.createCriteria(LinkMan.class);
		criteria.setFirstResult(10);
		criteria.setMaxResults(10);
		List<LinkMan> list = criteria.list();
		
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
		tx.commit();
	}
	
	@Test
	/**
	 * 条件查询
	 */
	public void demo4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 条件查询
		Criteria criteria = session.createCriteria(Customer.class);
		// 设置条件:
		/**
		 * =   eq
		 * >   gt
		 * >=  ge
		 * <   lt
		 * <=  le
		 * <>  ne
		 * like
		 * in
		 * and
		 * or
		 */
		criteria.add(Restrictions.eq("cust_source", "小广告"));
//		criteria.add(Restrictions.or(Restrictions.like("cust_name", "李%")));
		criteria.add(Restrictions.like("cust_name", "李%"));
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
	}
	
	@Test
	/**
	 * 统计查询
	 */
	public void demo5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		/**
		 * add				:普通的条件。where后面条件
		 * addOrder			:排序
		 * setProjection	:聚合函数 和 group by having
		 */
		criteria.setProjection(Projections.rowCount());
		Long num = (Long) criteria.uniqueResult();
		System.out.println(num);
		tx.commit();
	}
	
	@Test
	/**
	 * 离线条件查询
	 */
	public void demo6(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("cust_name", "李%"));
		
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		transaction.commit();
	}
}
