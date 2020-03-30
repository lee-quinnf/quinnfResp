package com.ben.s2sh.domain;

import java.io.Serializable;

import org.hibernate.impl.SessionFactoryImpl;

public class Person implements Serializable{
	private Long pid;
	private String name;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
