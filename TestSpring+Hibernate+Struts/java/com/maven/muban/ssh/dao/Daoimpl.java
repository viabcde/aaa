package com.maven.muban.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.maven.muban.ssh.model.Student;

public class Daoimpl implements Dao{
	
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<Student> findAll() {
		System.out.println("find");
		return /*(List<student>) hibernateTemplate.find("from student")*/ null;
	}


	@Override
	public void save(Student student) {
		hibernateTemplate.save(student);
		System.out.println("dao");
	}

}
