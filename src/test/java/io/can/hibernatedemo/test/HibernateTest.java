package io.can.hibernatedemo.test;

import java.util.Date;

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
	
	@Test
	public void testFieldLevelAccess() {
		
		// Pet icerisindeki birthDate field'ý getter setter yazilmadan
		// hibernate'in reflection ile field'a ulasmasi gozlenmistir.
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Pet pet = new Pet("Berf", new Date());
		pet.setId(1L);
		
		session.persist(pet);
		tx.commit();
		session.close();
		
		session = HibernateConfig.getSessionFactory().openSession();
		
		Pet pet2 = session.get(Pet.class, 1L);
		
		System.out.println(pet2);
		
		HibernateConfig.getSessionFactory().close();
	}
	

}
