package cn.ben.dao.impl;

import org.hibernate.Session;

import cn.ben.dao.LinkManDao;
import cn.ben.domain.LinkMan;
import cn.ben.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	public void save(LinkMan lm) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}

}
