package io.can.hibernatedemo.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import io.can.hibernatedemo.config.HibernateConfig;

public class HibernateTest {

	@Test
	public void testHibernateSetup() {
		Session session = HibernateConfig.getSessionFactory().openSession(); // open session
		Transaction tx = session.beginTransaction(); // begin transaction
		// persistence
		tx.commit(); // if persistence is success transaction commit, not else transaction rollback
		session.close(); // session close
		HibernateConfig.getSessionFactory().close(); // sessionFactory close if application was shutting down
	}
	
}
