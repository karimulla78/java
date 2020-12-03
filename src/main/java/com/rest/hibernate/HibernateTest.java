package com.rest.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		SessionFactory sessionFactory = conf.buildSessionFactory(builder.build()); 
		Session session = sessionFactory.openSession();
		System.out.println("--------Session----"+session);
        session.beginTransaction();
        
        //one-to-one
        
        Student student = new Student("Karim", "Basha", "karimulla0078@gmail.com", "8789876765" );
        StudentAddress studentAddress = new StudentAddress("g-147, sec-44", "new delhi", "new delhi", "india");
        
        student.setStudentAddress(studentAddress);
        
        
        
        studentAddress.setStudent(student);
        
        session.save(student);
       
        //one-to-many
        
       /* Student student = new Student("John", "Smith",
        	    "beingjavaguy@gmail.com", "11111111");
        session.save(student);

       MarksDetails marksDetails1 = new MarksDetails("Maths", "100", "87",
        	    "Passed");
       MarksDetails marksDetails2 = new MarksDetails("Science", "100", "90",
        	    "Passed");
       MarksDetails marksDetails3 = new MarksDetails("English", "100", "85",
        	    "Passed");

        marksDetails1.setStudent(student);
        marksDetails2.setStudent(student);
        marksDetails3.setStudent(student);

        session.save(marksDetails1);
        session.save(marksDetails2);
        session.save(marksDetails3);*/
        
        
        
        session.getTransaction().commit();
        session.close();
		

	}

}
