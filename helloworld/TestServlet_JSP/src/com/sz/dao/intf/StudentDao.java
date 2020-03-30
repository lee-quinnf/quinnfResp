package com.sz.dao.intf;

import java.util.List;

import com.sz.model.Student;

public interface StudentDao {
	List<Student> findAll();
}
