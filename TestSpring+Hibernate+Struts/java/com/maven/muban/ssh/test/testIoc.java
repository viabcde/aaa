package com.maven.muban.ssh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven.muban.ssh.service.Service;

public class testIoc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Service s = (Service) ac.getBean("service");
		s.findAll();

	}

}
