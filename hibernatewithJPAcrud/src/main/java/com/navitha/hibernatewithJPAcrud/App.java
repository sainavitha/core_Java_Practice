package com.navitha.hibernatewithJPAcrud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class App 
{
    public static void main( String[] args )
    {
    	//look jpa create table with a name called student and insert records
    	//persist() use to store the data permanently
    	Student s =new Student();
    	s.setId(108);
    	s.setName("Rajesh");
    	s.setAge(29);
    	EntityManagerFactory emf =Persistence.createEntityManagerFactory("PU");
    	EntityManager em= emf.createEntityManager();
    	em.getTransaction().begin();
    	//em.persist(s);
    	// update the existing records
    	//System.out.println(s);
    	//Student existingStudent =em.find(Student.class, 105);
    //if(existingStudent!=null)
    //{
    //	existingStudent.setName("Teja");
    	//existingStudent.setAge(99);
    //}
    //em.getTransaction().commit();
    //to check whether its updated or not
    //existingStudent=em.find(Student.class, 105);
    //System.out.println("Updated student_info is :"+existingStudent);
    	//delete the records
    	//delete all the rows in table
    	int deletedCount=em.createQuery("delete from Student").executeUpdate();
    	em.getTransaction().commit();
    	//optional
    	System.out.println("Delete all the rows in student table .total rows deleted: 4");
    	em.close();
    	emf.close();
    }
}