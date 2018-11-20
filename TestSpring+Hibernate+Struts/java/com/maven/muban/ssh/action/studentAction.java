package com.maven.muban.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.maven.muban.ssh.model.Student;
import com.maven.muban.ssh.service.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class studentAction extends ActionSupport implements ModelDriven<Student>{
	
	Student s= new Student();
	private Service service;
	
	public Service getService() {
		return service;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	private List<Student> students;


	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return s;
	}
/*	public studentAction() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Service s = (Service) ac.getBean("service");
		this.setService(s);
		
		
//		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
//		Service s = (Service) ac.getBean("service");
//		this.setService(s);
	}*/
		
	public String add(){
		return "add";	
	}
	
	public String findAll(){
		students=service.findAll();
		return "success";
	}



	
	
}
