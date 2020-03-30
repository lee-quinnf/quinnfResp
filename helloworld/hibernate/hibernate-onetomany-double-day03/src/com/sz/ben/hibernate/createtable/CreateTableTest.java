package com.sz.ben.hibernate.createtable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CreateTableTest {
	@Test
	public void testCreateTable(){
		/**
		 * 加载了hibernate的配置文件
		 */
		Configuration configuration =  new Configuration();
		/**
		 * 要求配置文件：
		 *     1、必须是classpath的根目录
		 *     2、文件的名称必须是hibernate.cfg.xml
		 */
		configuration.configure();
		//configuration.configure("");//参数为hibernate配置文件的路径及名称
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
	}
}
