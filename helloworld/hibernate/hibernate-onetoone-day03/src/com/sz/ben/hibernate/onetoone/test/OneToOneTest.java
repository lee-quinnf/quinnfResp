package com.sz.ben.hibernate.onetoone.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sz.ben.hibernate.onetoone.Course;
import com.sz.ben.hibernate.onetoone.Person;
import com.sz.ben.hibernate.utils.HibernateUtils;

/**
 * ��Զ�Ĳ���
 * @author zd
				��������
					����γ̵�ʱ�򣬼�������ѧ��
 */
public class OneToOneTest extends HibernateUtils{
	@Test
	public void testSavePersonAndCourse(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setName("��1");
		Course course1 = new Course();
		course1.setName("��10��");
		
		//����person��course1,course2֮��Ĺ�ϵ
		Set<Course> courses = new HashSet<Course>();
		courses.add(course1);
		person.setCourses(courses);
		
		session.save(person);
		transaction.commit();
	}
}
