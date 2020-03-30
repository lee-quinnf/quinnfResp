package com.sz.ben.hibernate.sf.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sz.ben.hibernate.sessionfactory.domain.Classes;
import com.sz.ben.hibernate.sessionfactory.domain.Student;
import com.sz.ben.hibernate.utils.HibernateUtils;

public class SessionFactoryTest extends HibernateUtils{
	/**
	 * session.get方法把对象放入到了二级缓存中
	 *     先从一级缓存中查找数据,再从二级缓存中查找数据,最后从数据库中查询数据
	 *        把查找出来的数据放入到一级和二级缓存中
	 */
	@Test
	public void testGet(){
		Session session = sessionFactory.openSession();
		Classes classes = (Classes)session.get(Classes.class, 1L);
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());
		session.close();//一级缓存的数据没有了
		session = sessionFactory.openSession();
		classes = (Classes)session.get(Classes.class, 1L);
		session.close();
	}
	
	/**
	 * save方法
	 *    save方法不能把对象放入到二级缓存中
	 */
	@Test
	public void testSave(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Classes classes = new Classes();
		classes.setName("aaa");
		session.save(classes);
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		Classes classes2 = (Classes)session.get(Classes.class, classes.getCid());
		session.close();
	}
	
	/**
	 * session.update方法也不能把对象放入到二级缓存中
	 */
	@Test
	public void testUpdate(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = new Classes();
		classes.setCid(1L);
		classes.setName("aaa");
		session.update(classes);
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());
		transaction.commit();
		session.close();
	}
	
	/**
	 * list方法
	 *   list方法可以把对象放入到二级缓存中
	 */
	@Test
	public void testList(){
		Session session = sessionFactory.openSession();
		session.createQuery("from Classes").list();
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());//输出有值
		session.close();
	}
	
	@Test
	public void testRead_Only(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes)session.get(Classes.class, 1L);
		classes.setDescription("aaaa");
		transaction.commit();
		session.close();//一级缓存的数据没有了
	}
	
	/**
	 * 把cid为1的班级提取出来，再把该班级中的所有的学生提取出来
	 */
	@Test
	public void testGetStudentFromClasses(){
		Session session = sessionFactory.openSession();
		Classes classes = (Classes)session.get(Classes.class, 1L);
		Set<Student> students = classes.getStudents();
		for (Student student : students) {
			System.out.println(student.getName());
		}
		System.out.println(sessionFactory.getStatistics().getCollectionLoadCount());
		session.close();
	}
	
	/**
	 * 利用list方法把对象放入到二级缓存中，如果内存存放不下，则
	 * 缓存到磁盘上
	 */
	@Test
	public void testOverFlowToDisk() throws Exception{
		Session session = sessionFactory.openSession();
		session.createQuery("from Classes").list();
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());
		sessionFactory.getCache().evictEntity(Classes.class, 1L);
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());
		Thread.sleep(1000l);
		session.close();
	}
}
