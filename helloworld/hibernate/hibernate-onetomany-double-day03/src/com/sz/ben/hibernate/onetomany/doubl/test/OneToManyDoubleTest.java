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
 * һ�Զ�ĵ���
 * @author zd
 *				һ�����
					1������༶
					2������ѧ��
					3������༶������ѧ��

				��������
					4������༶��������ѧ��
					5������༶��������ѧ��
					6�����°༶��������ѧ��
					7�����°༶��������ѧ��
					8��ɾ���༶����ɾ��ѧ��
					9���ڰ༶�м���save-update������£��ӹ����õ�ѧ��������ɾ��ѧ����

				��ϵ����
					8���Ѿ�����һ���༶���½�һ��ѧ�����Ѹ�ѧ�����뵽�ð༶(������ϵ����)
					9���Ѿ�����һ��ѧ�����½�һ���༶���Ѹ�ѧ�����뵽�ð༶(������ϵ����)
					10���Ѿ�����һ��ѧ�����Ѿ�����һ���༶���Ѹ�ѧ�����뵽�ð༶
					11���Ѿ�����һ��ѧ������һ��ѧ����һ���༶ת�Ƶ�����һ���༶
					12�����һ���༶�����е�ѧ��֮��Ĺ�ϵ
					13����������һ���༶��ѧ��
				�����͹�ϵ�Ļ�ϣ�
					13����ɾ���༶��ʱ�򣬽���༶��ѧ��֮��Ĺ�ϵ
 */
public class OneToManyDoubleTest extends HibernateUtils{
	/**
	 * �ڱ���ѧ����ʱ�򣬼�������༶
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
		student.setName("����");
		
		Classes classes = new Classes();
		classes.setName("apple");
		
		//����ѧ����༶֮��Ĺ�ϵ
		student.setClasses(classes);
		
		session.save(student);
		transaction.commit();
	}
	
	/**
	 * �ڸ���ѧ����ʱ�򣬱���༶
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
		
		//����ѧ����༶֮��Ĺ�ϵ
		student.setClasses(classes);
	
		transaction.commit();
	}
	
	/**
	 * �Ѿ�����һ���༶���Ѿ�����һ��ѧ�����ø�ѧ�����뵽�ð༶
	 *    ��sidΪ3��ѧ�����뵽cidΪ5�İ༶
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
		//����ѧ���Ͱ༶֮��Ĺ�ϵ
		student.setClasses(classes);
		transaction.commit();
	}
	
	/**
	 * ��sidΪ1��ѧ����cidΪ5�İ༶ת��3�İ༶
	 */
	@Test
	public void testTransform(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes)session.get(Classes.class, 3L);
		Student student = (Student)session.get(Student.class, 1L);
		//������ϵ
		student.setClasses(classes);
		transaction.commit();
	}
	
	/**
	 * ���һ���༶�����е�ѧ��֮��Ĺ�ϵ
	 */
	@Test
	public void testRealseAllR(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//��ȡcidΪ3�İ༶
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
			     ���������������ϵ��sql��䣬�Ǹ���ÿһ��sid���н���ģ���Ϊ�ð༶����������ѧ��������������sql���
		 */
		for (Student student : students) {
			student.setClasses(null);
		}
		transaction.commit();
	}
}
