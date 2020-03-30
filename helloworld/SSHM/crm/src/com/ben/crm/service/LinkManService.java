package com.ben.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ben.crm.domain.LinkMan;
import com.ben.crm.domain.PageBean;

/**
 * 联系人的Service的接口
 * @author quinnf
 *
 */
public interface LinkManService {

	PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

}
