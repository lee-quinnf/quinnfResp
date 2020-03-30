package com.ben.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ben.crm.domain.Customer;
import com.ben.crm.domain.PageBean;

/**
 * 客户管理的Service的接口
 * @author quinnf
 */
public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage,Integer pageSize);

	Customer findById(Long cust_id);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();

}
