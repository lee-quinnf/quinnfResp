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
 * 多对多的操作
 * @author zd
				级联操作
					保存课程的时候，级联保存学生
 */
public class OneToOneTest extends HibernateUtils{
	@Test
	public void testSavePersonAndCourse(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setName("黑1");
		Course course1 = new Course();
		course1.setName("云10期");
		
		//建立person与course1,course2之间的关系
		Set<Course> courses = new HashSet<Course>();
		courses.add(course1);
		person.setCourses(courses);
		
		session.save(person);
		transaction.commit();
	}
}
