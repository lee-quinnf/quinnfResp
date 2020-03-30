package cn.sz.ben.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate的工具类
 * @author quinnf
 *
 */
public class HibernateUtils {

	public static final Configuration cfg;
	public static final SessionFactory sf;
	
	static{
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	
	public static Session openSession(){
		return sf.openSession();
	}
	
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
}
