package com.sz.ben.hibernate.onetomany.doubl.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sz.ben.hibernate.onetomany.doubl.Classes;
import com.sz.ben.hibernate.onetomany.doubl.Student;
import com.sz.ben.hibernate.utils.HibernateUtils;

/**
 * 一对多的单项
 * @author zd
 *				一般操作
					1、保存班级
					2、保存学生
					3、保存班级，保存学生

				级联操作
					4、保存班级级联保存学生
					5、保存班级级联更新学生
					6、更新班级级联保存学生
					7、更新班级级联更新学生
					8、删除班级级联删除学生
					9、在班级有级联save-update的情况下，从关联得到学生，并且删除学生？

				关系操作
					8、已经存在一个班级，新建一个学生，把该学生加入到该班级(建立关系操作)
					9、已经存在一个学生，新建一个班级，把该学生加入到该班级(建立关系操作)
					10、已经存在一个学生，已经存在一个班级，把该学生加入到该班级
					11、已经存在一个学生，把一个学生从一个班级转移到另外一个班级
					12、解除一个班级和所有的学生之间的关系
					13、重新设置一个班级的学生
				级联和关系的混合：
					13、在删除班级的时候，解除班级和学生之间的关系
 */
public class OneToManyDoubleTest extends HibernateUtils{
	/**
	 * 在保存学生的时候，级联保存班级
	 * 	insert 
		    into
		        Student
		        (name, description, cid, sid) 
		    values
		        (?, ?, ?, ?)
	 */
	@Test
	public void testSaveStudent_Cascade_SaveClasses(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setName("果粉");
		
		Classes classes = new Classes();
		classes.setName("apple");
		
		//建立学生与班级之间的关系
		student.setClasses(classes);
		
		session.save(student);
		transaction.commit();
	}
	
	/**
	 * 在更新学生的时候，保存班级
	 *     update
		        Student 
		    set
		        name=?,
		        description=?,
		        cid=? 
		    where
		        sid=?
	 */
	@Test
	public void testUpdateStudent_Cascade_SaveClasses(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = (Student)session.get(Student.class, 3L);
		
		Classes classes = new Classes();
		classes.setName("asdf");
		
		//建立学生与班级之间的关系
		student.setClasses(classes);
	
		transaction.commit();
	}
	
	/**
	 * 已经存在一个班级，已经存在一个学生，让该学生加入到该班级
	 *    把sid为3的学生加入到cid为5的班级
	 *    update
		        Student 
		    set
		        name=?,
		        description=?,
		        cid=? 
		    where
		        sid=?
	 */
	@Test
	public void testBuildR(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student)session.get(Student.class, 3L);
		Classes classes = (Classes)session.get(Classes.class, 5L);
		//建立学生和班级之间的关系
		student.setClasses(classes);
		transaction.commit();
	}
	
	/**
	 * 把sid为1的学生从cid为5的班级转到3的班级
	 */
	@Test
	public void testTransform(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes)session.get(Classes.class, 3L);
		Student student = (Student)session.get(Student.class, 1L);
		//建立关系
		student.setClasses(classes);
		transaction.commit();
	}
	
	/**
	 * 解除一个班级和所有的学生之间的关系
	 */
	@Test
	public void testRealseAllR(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//提取cid为3的班级
		Classes classes = (Classes)session.get(Classes.class, 3L);
		Set<Student> students = classes.getStudents();
		/**
		 * Hibernate: 
			    update
			        Student 
			    set
			        name=?,
			        description=?,
			        cid=? 
			    where
			        sid=?
			Hibernate: 
			    update
			        Student 
			    set
			        name=?,
			        description=?,
			        cid=? 
			    where
			        sid=?
			     发出了两条解除关系的sql语句，是根据每一个sid进行解除的，因为该班级现在有两个学生，所以有两条sql语句
		 */
		for (Student student : students) {
			student.setClasses(null);
		}
		transaction.commit();
	}
}
