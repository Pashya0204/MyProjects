package com.project.student.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.student.pojo.StudentPOJO;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;

	private static void open() {
		factory = Persistence.createEntityManagerFactory("mvc");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

	}

	private static void close() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public StudentPOJO addStudent(String name, String email, double percent, long contact) {
		open();
		transaction.begin();
		StudentPOJO student = new StudentPOJO();
		student.setName(name);
		student.setEmail(email);
		student.setPercentage(percent);
		student.setContact(contact);
		manager.persist(student);
		transaction.commit();
		close();
		return student;
	}

	public StudentPOJO searchStudent(int id) {
		open();
		transaction.begin();
		
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		transaction.commit();
		close();
		return student;
	}

	public List<StudentPOJO> searchAllStudent() {
		open();
		transaction.begin();
		jpql = "from StudentPOJO";
		query = manager.createQuery(jpql);
		List<StudentPOJO> students = query.getResultList();
		transaction.commit();
		close();
		return students;
	}

	public StudentPOJO removeStudent(int id) {
		open();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		manager.remove(student);
		transaction.commit();
		close();
		return student;
	}

	public void updateStudent(int id, String name, String email, long contact, double percent) {
		open();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		student.setName(name);
		student.setEmail(email);
		student.setContact(contact);
		student.setPercentage(percent);
		manager.persist(student);
		transaction.commit();
		close();
		
	}

}
