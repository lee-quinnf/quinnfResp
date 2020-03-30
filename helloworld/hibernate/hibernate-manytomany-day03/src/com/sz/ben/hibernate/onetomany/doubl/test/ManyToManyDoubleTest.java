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
 * 多对多的操作
 * @author zd
				级联操作
					保存课程的时候，级联保存学生
 */
public class ManyToManyDoubleTest extends HibernateUtils{
	/**
	 * 
	 * 保存课程的时候，级联保存学生
	 * insert 
	    into
	        student_course
	        (cid, sid) 
	    values
	        (?, ?)
	         建立关系的insert语句，是由course维护关系的
	 */
	@Test
	public void testSaveCourse_Cascade_Save_Student(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =  session.beginTransaction();
		Course course = new Course();
		course.setName("hibernate课程");
		course.setDescription("比较难学");
		Student student = new Student();
		student.setName("班长");
		//建立课程与学生之间的关系
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		course.setStudents(students);
		session.save(course);
		transaction.commit();
	}
	
	/**
	 * 在更新课程的时候，级联更新学生
	 */
	@Test
	public void testUpdateCourse_Cascade_Update_Student(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction =  session.beginTransaction();
		Course course = (Course)session.get(Course.class, 1L);
		//选修该课程的所有的学生
		Set<Student> students = course.getStudents();
		for (Student student : students) {
			student.setName("asfd");
		}
		transaction.commit();
	}
	
	/**
	 * 解除课程1和所有的学生之间的关系
	 *     delete 
			    from
			        student_course 
			    where
			        cid=?
			   把第三张表中针对cid为1的数据全部删除了

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
	 * 把学生1从课程1转到课程2
	 *    Hibernate:   解除关系
		    delete 
		    from
		        student_course 
		    where
		        sid=? 
		        and cid=?
		Hibernate:    增加关系
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
		student.getCourses().remove(course1);//解除关系
		student.getCourses().add(course2);//建立关系
		transaction.commit();
	}
	
	/**
	 * 删除一个学生
	 * Hibernate: 
		    delete   解除关系
		    from
		        student_course 
		    where
		        sid=?
		Hibernate: 
		    delete 删除学生
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
