package com.maven.muban.ssh.service;

import java.util.List;

import com.maven.muban.ssh.model.Student;

import com.maven.muban.ssh.dao.*;

public class serviceImpl implements Service {
	private Dao dao;

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Student student) {
		System.out.println("service");
		dao.save(student);
		
	}



}