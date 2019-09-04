package io.can.hibernatedemo.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import io.can.hibernatedemo.config.HibernateConfig;
import io.can.hibernatedemo.model.Pet;

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

	@Test
	public void testCreateEntity() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// persistence
		Pet pet = new Pet();
		pet.setId(1L); // assigned primary key approach
		pet.setName("Berf");
		session.persist(pet);

		tx.commit();
		session.close();
		HibernateConfig.getSessionFactory().close();
	}

}
