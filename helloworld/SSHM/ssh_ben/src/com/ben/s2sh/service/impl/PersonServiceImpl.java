package com.ben.s2sh.service.impl;

import com.ben.s2sh.dao.PersonDao;
import com.ben.s2sh.domain.Person;
import com.ben.s2sh.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void savePerson(Person person) {
		this.personDao.savePerson(person);
	}
}
