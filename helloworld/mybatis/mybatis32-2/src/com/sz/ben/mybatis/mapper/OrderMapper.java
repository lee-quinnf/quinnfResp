package com.sz.ben.mybatis.mapper;

import java.util.List;

import com.sz.ben.mybatis.pojo.Orders;
import com.sz.ben.mybatis.pojo.User;

public interface OrderMapper {
	
	
//	查询订单表order的所有数据

	public List<Orders> selectOrdersList();
	
	//一对一关联 查询  以订单为中心 关联用户
	public List<Orders> selectOrders();
	
	//一对多关联
	public List<User> selectUserList();
	
}
