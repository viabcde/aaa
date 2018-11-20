package com.maven.muban.ssh.dao;

import java.util.List;

import com.maven.muban.ssh.model.Student;

public interface Dao {

	List<Student> findAll();

	void save(Student student);

}
