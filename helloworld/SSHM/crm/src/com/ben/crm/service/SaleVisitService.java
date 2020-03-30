package com.ben.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ben.crm.domain.PageBean;
import com.ben.crm.domain.SaleVisit;

/**
 * 客户拜访记录的业务层的接口
 * @author quinnf
 *
 */
public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);

}
