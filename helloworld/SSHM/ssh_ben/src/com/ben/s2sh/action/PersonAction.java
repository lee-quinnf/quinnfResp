package com.ben.s2sh.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.spring.StrutsSpringObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ben.s2sh.domain.Person;
import com.ben.s2sh.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport{
	private PersonService personService;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public String savePerson(){
//		ApplicationContext context = WebApplicationContextUtils.
//			getRequiredWebApplicationContext(
//					ServletActionContext.getServletContext()
//					);
//		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setName("黄渤");
		personService.savePerson(person);
		return null;
	}
}
