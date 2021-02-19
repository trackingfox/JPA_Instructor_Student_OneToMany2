package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	@Test
	public void DemoInstructor_stud() {

//		SessionFactory sessionFactory = null;
//		// configures settings from hibernate.cfg.xml
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//
//		try {
//			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//		} catch (Exception ex) {
//			System.out.println(ex.toString()); // If error display in console
//			StandardServiceRegistryBuilder.destroy(registry);
//		}
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//
//		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
//
//		// associate the objects
//		tempInstructor.setInstructorDetail(tempInstructorDetail);
////
//
////		session.beginTransaction();
////		List<Student> studentlist = this.csvToclass();
////		studentlist.forEach(x -> session.save(x));
////		session.getTransaction().commit();
//
//		// save the instructor
////		//
////		// Note: this will ALSO save the details object
////		// because of CascadeType.ALL
////		//
//		System.out.println("Saving instructor: " + tempInstructor);
//		session.save(tempInstructor);
//
//		// commit transaction
//		session.getTransaction().commit();
//		session.close();
//---------------------------------------------------------------------------------------------------------------------------------------
//		// create session factory
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
//				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
//
//		// create session
//		Session session = factory.getCurrentSession();
//
//		try {
//
//			// create the objects
//			/*
//			 * Instructor tempInstructor = new Instructor("Chad", "Darby",
//			 * "darby@luv2code.com");
//			 * 
//			 * InstructorDetail tempInstructorDetail = new InstructorDetail(
//			 * "http://www.luv2code.com/youtube", "Luv 2 code!!!");
//			 */
//
//			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
//
//			// associate the objects
//			tempInstructor.setInstructorDetail(tempInstructorDetail);
//
//			// start a transaction
//			session.beginTransaction();
//
//			// save the instructor
//			//
//			// Note: this will ALSO save the details object
//			// because of CascadeType.ALL
//			//
//			System.out.println("Saving instructor: " + tempInstructor);
//			session.save(tempInstructor);
//
//			// commit transaction
//			session.getTransaction().commit();
//
//			System.out.println("Done!");
//		} finally {
//			factory.close();
//		}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		// using persistance.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Instructor_Student2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		em.persist(tempInstructor);
		em.persist(tempInstructorDetail);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
