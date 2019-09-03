package io.can.hibernatedemo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import io.can.hibernatedemo.config.JpaConfig;

public class JpaConfigTest {

	@Test
	public void testJpaSetup() {
		EntityManagerFactory entityManagerFactory = JpaConfig.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager(); // get entity Manager
		EntityTransaction tx = entityManager.getTransaction(); // get transaction
		tx.begin(); // begin transaction
		// persistence
		tx.commit(); // if persistence is success transaction commit, not else transaction rollback
		entityManager.close(); // close entity manager
		entityManagerFactory.close(); // entityManagerFactory close if application was shutting down
	}
	
}
