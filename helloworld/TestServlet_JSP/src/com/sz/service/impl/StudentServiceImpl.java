package com.sz.service.impl;

import java.util.List;

import com.sz.dao.impl.StudentDaoImpl;
import com.sz.dao.intf.StudentDao;
import com.sz.model.Student;
import com.sz.service.intf.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findAll();
	}

}
