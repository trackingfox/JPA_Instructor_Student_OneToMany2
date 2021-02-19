package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luv2code.hibernate.demo.entity.Course;

public class DeleteCourseDemo {

	public static void main(String[] args) {

//		// create session factory
//		SessionFactory factory = new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Instructor.class)
//								.addAnnotatedClass(InstructorDetail.class)
//								.addAnnotatedClass(Course.class)
//								.buildSessionFactory();
//		
//		// create session
//		Session session = factory.getCurrentSession();
//		
//		try {			
//			
//			// start a transaction
//			session.beginTransaction();
//			
//			// get a course
//			int theId = 10;
//			Course tempCourse = session.get(Course.class, theId);
//			
//			// delete course
//			System.out.println("Deleting course: " + tempCourse);
//			
//			session.delete(tempCourse);
//
//			// commit transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Done!");
//		}
//		finally {
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

		// get a course
		int theId = 10;
		Course tempCourse = em.find(Course.class, theId);

		// delete course
		System.out.println("Deleting course: " + tempCourse);

		em.remove(tempCourse);

		// commit transaction
		em.getTransaction().commit();

		System.out.println("Done!");

		System.out.println("Done!");

		em.close();
		emf.close();
	}

}
