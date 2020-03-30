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
	 * session.get�����Ѷ�����뵽�˶���������
	 *     �ȴ�һ�������в�������,�ٴӶ��������в�������,�������ݿ��в�ѯ����
	 *        �Ѳ��ҳ��������ݷ��뵽һ���Ͷ���������
	 */
	@Test
	public void testGet(){
		Session session = sessionFactory.openSession();
		Classes classes = (Classes)session.get(Classes.class, 1L);
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());
		session.close();//һ�����������û����
		session = sessionFactory.openSession();
		classes = (Classes)session.get(Classes.class, 1L);
		session.close();
	}
	
	/**
	 * save����
	 *    save�������ܰѶ�����뵽����������
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
	 * session.update����Ҳ���ܰѶ�����뵽����������
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
	 * list����
	 *   list�������԰Ѷ�����뵽����������
	 */
	@Test
	public void testList(){
		Session session = sessionFactory.openSession();
		session.createQuery("from Classes").list();
		System.out.println(sessionFactory.getStatistics().getEntityLoadCount());//�����ֵ
		session.close();
	}
	
	@Test
	public void testRead_Only(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes)session.get(Classes.class, 1L);
		classes.setDescription("aaaa");
		transaction.commit();
		session.close();//һ�����������û����
	}
	
	/**
	 * ��cidΪ1�İ༶��ȡ�������ٰѸð༶�е����е�ѧ����ȡ����
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
	 * ����list�����Ѷ�����뵽���������У�����ڴ��Ų��£���
	 * ���浽������
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
