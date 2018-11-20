package com.maven.muban.ssh.service;

import java.util.List;

import com.maven.muban.ssh.model.Student;

public interface Service {

	public abstract List<Student> findAll();

	public abstract void save(Student student);

}