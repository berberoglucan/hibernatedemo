package io.can.hibernatedemo.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConfig {

	private static EntityManagerFactory entityManagerFactory;

	static {
		// test -> persistence unit name in persistence.xml file
		entityManagerFactory = Persistence.createEntityManagerFactory("test");
	}
	
	private JpaConfig() {}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
