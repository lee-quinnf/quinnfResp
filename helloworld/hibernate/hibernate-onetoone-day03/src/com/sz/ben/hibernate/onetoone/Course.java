package com.sz.ben.hibernate.onetoone;

import java.io.Serializable;

public class Course implements Serializable{
	private Long cid;
	private String name;
	private Person person;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
