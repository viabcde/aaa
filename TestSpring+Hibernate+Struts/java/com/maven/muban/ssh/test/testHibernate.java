package com.maven.muban.ssh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.maven.muban.ssh.model.Student;;



public class testHibernate {


	public static void main(String[] args) {
		Student s=new Student();
		//s.setId(2);
		s.setName("ccc");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(s);
		tx.commit();
		//session.close();
		factory.close();
	}

}
