package com.sz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sz.dao.intf.StudentDao;
import com.sz.model.Student;
import com.sz.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs   = null;
		try {
			//1. 得到连接对象
			conn = JDBCUtil.getConn();

			String sql = "select * from t_stu";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			//数据多了，用对象装， 对象也多了呢？ 用集合装。 
			while(rs.next()){ //10 次 ，10个学生

				Student stu = new Student();

				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setName(rs.getString("name"));


				list.add(stu);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);
		}

		return list;
	}

}
