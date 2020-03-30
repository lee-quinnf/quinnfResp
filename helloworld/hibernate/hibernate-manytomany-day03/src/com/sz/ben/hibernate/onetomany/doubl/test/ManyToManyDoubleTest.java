package com.sz.ben.hibernate.onetomany.doubl.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sz.ben.hibernate.manytomany.Course;
import com.sz.ben.hibernate.manytomany.Student;
import com.sz.ben.hibernate.utils.HibernateUtils;

/**
 * ��Զ�Ĳ���
 * @author zd
				��������
					����γ̵�ʱ�򣬼�������ѧ��
 */
public class ManyToManyDoubleTest extends HibernateUtils{
	/**
	 * 
	 * ����γ̵�ʱ�򣬼�������ѧ��
	 * insert 
	    into
	        student_course
	        (cid, sid) 
	    values
	        (?, ?)
	         ������ϵ��insert��䣬����courseά����ϵ��
	 */
	@Test
	public void testSaveCourse_Cascade_Save_Student(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =  session.beginTransaction();
		Course course = new Course();
		course.setName("hibernate�γ�");
		course.setDescription("�Ƚ���ѧ");
		Student student = new Student();
		student.setName("�೤");
		//�����γ���ѧ��֮��Ĺ�ϵ
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		course.setStudents(students);
		session.save(course);
		transaction.commit();
	}
	
	/**
	 * �ڸ��¿γ̵�ʱ�򣬼�������ѧ��
	 */
	@Test
	public void testUpdateCourse_Cascade_Update_Student(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =  session.beginTransaction();
		Course course = (Course)session.get(Course.class, 1L);
		//ѡ�޸ÿγ̵����е�ѧ��
		Set<Student> students = course.getStudents();
		for (Student student : students) {
			student.setName("asfd");
		}
		transaction.commit();
	}
	
	/**
	 * ����γ�1�����е�ѧ��֮��Ĺ�ϵ
	 *     delete 
			    from
			        student_course 
			    where
			        cid=?
			   �ѵ����ű������cidΪ1������ȫ��ɾ����

	 */
	@Test
	public void testRealseAllR(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =  session.beginTransaction();
		Course course = (Course)session.get(Course.class, 1L);
		course.setStudents(null);
		transaction.commit();
	}
	
	/**
	 * ��ѧ��1�ӿγ�1ת���γ�2
	 *    Hibernate:   �����ϵ
		    delete 
		    from
		        student_course 
		    where
		        sid=? 
		        and cid=?
		Hibernate:    ���ӹ�ϵ
		    insert 
		    into
		        student_course
		        (sid, cid) 
		    values
		        (?, ?)

	 */
	@Test
	public void testStudentFromCourseToCourse(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =  session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1L);
		Course course1 = (Course)session.get(Course.class, 1L);
		Course course2 = (Course)session.get(Course.class, 2L);
		student.getCourses().remove(course1);//�����ϵ
		student.getCourses().add(course2);//������ϵ
		transaction.commit();
	}
	
	/**
	 * ɾ��һ��ѧ��
	 * Hibernate: 
		    delete   �����ϵ
		    from
		        student_course 
		    where
		        sid=?
		Hibernate: 
		    delete ɾ��ѧ��
		    from
		        Student 
		    where
		        sid=?
	 */
	@Test
	public void testDeleteStudent(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =  session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1L);
		session.delete(student);
		transaction.commit();
	}
}
