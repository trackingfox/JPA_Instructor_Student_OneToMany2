package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.luv2code.hibernate.demo.entity.Instructor;

public class GetInstructorCoursesDemo {

	@Test
	public void InstructorCourseDemo() {

		// create session factory
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
//				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
//
//		// create session
//		Session session = factory.getCurrentSession();
//
//		try {
//
//			// start a transaction
//			session.beginTransaction();
//
//			// get the instructor from db
//			int theId = 1;
//			Instructor tempInstructor = session.get(Instructor.class, theId);
//
//			System.out.println("Instructor: " + tempInstructor);
//
//			// get courses for the instructor
//			System.out.println("Courses: " + tempInstructor.getCourses());
//
//			// commit transaction
//			session.getTransaction().commit();
//
//			System.out.println("Done!");
//		} finally {
//
//			// add clean up code
//			session.close();
//
//			factory.close();
//		}

		// using persistance.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Instructor_Student2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// get the instructor from db
		int theId = 1;
		Instructor tempInstructor = em.find(Instructor.class, theId);

		System.out.println("Instructor: " + tempInstructor);

		// get courses for the instructor
		System.out.println("Courses: " + tempInstructor.getCourses());

		// commit transaction
		em.getTransaction().commit();

		System.out.println("Done!");

		em.close();
		emf.close();
	}

}
