package com.ben.crm.service;

import com.ben.crm.pojo.Customer;
import com.ben.crm.pojo.QueryVo;
import com.ben.crm.utils.Page;

/**
 * 客户信息业务逻辑接口
 * @author quinnf
 *
 */
public interface CustomerService {

	/**
	 * 查询查询条件，分页查询用户列表
	 * @param vo
	 * @return
	 */
	Page<Customer> getCustomerByQueryVo(QueryVo vo);
	
	
	/**
	 * 跟据id查询用户信息
	 * @param id
	 * @return
	 */
	Customer getCustomerById(Integer id);
	
	/**
	 * 更新用户信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	void deleteCustomer(Integer id);
}
