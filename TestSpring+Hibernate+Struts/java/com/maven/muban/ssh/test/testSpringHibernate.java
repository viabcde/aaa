package com.maven.muban.ssh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maven.muban.ssh.model.Student;
import com.maven.muban.ssh.service.Service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class testSpringHibernate {
	
	@Autowired
	private Service cs;
	@Test
	public void testSave(){
		System.out.println("test");
		Student s = new Student();
		s.setName("testSpringHibernate");
		cs.save(s);
		cs.findAll();
	}
	
	@Test
	public void testfind(){
		
	}
}
