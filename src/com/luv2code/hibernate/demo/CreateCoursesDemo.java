package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class CreateCoursesDemo {

	@Test
	public void CourseDemo() {

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
//			// get the instructor from db
//			int theId = 1;
//			Instructor tempInstructor = session.get(Instructor.class, theId);		
//			
//			// create some courses
//			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
//			Course tempCourse2 = new Course("The Pinball Masterclass");
//			
//			// add courses to instructor
//			tempInstructor.add(tempCourse1);
//			tempInstructor.add(tempCourse2);
//			
//			// save the courses
//			session.save(tempCourse1);
//			session.save(tempCourse2);
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

		// get the instructor from db
		int theId = 1;
		Instructor tempInstructor = em.find(Instructor.class, theId);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the courses
		em.persist(tempCourse1);
		em.persist(tempCourse2);

		// commit transaction
		em.getTransaction().commit();

		System.out.println("Done!");

		em.close();
		emf.close();
	}

}
