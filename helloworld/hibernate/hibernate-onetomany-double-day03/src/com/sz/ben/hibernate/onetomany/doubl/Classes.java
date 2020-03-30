package com.sz.ben.hibernate.onetomany.doubl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Classes implements Serializable{
	private Long cid;
	private String name;
	private String description;
	
	private Set<Student> students;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
