package io.can.hibernatedemo.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	private static SessionFactory sessionFactory;

	static {
		// read the hibernate configuration from hibernate.cfg.xml file and get session
		// factory
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	private HibernateConfig() {}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
