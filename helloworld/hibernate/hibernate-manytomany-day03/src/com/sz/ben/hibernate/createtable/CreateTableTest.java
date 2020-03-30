package com.sz.ben.hibernate.createtable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CreateTableTest {
	@Test
	public void testCreateTable(){
		/**
		 * ������hibernate�������ļ�
		 */
		Configuration configuration =  new Configuration();
		/**
		 * Ҫ�������ļ���
		 *     1��������classpath�ĸ�Ŀ¼
		 *     2���ļ������Ʊ�����hibernate.cfg.xml
		 */
		configuration.configure();
		//configuration.configure("");//����Ϊhibernate�����ļ���·��������
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
	}
}
