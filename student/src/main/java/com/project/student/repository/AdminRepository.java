package com.project.student.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.student.pojo.AdminPOJO;


@Repository
public class AdminRepository {
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

	public AdminPOJO addAdmin(String username, String password) {
		open();
		transaction.begin();
		AdminPOJO admin = new AdminPOJO();
		admin.setUserName(username);
		admin.setPassword(password);
		manager.persist(admin);
		transaction.commit();
		close();
		return admin;
	}

	public AdminPOJO login(String username, String password) {
		open();
		transaction.begin();
		jpql ="from AdminPOJO where username ='"+username+"' and password ='"+password+"'";
		query =manager.createQuery(jpql);
		List<AdminPOJO> list= query.getResultList();
		for (AdminPOJO admin : list) {
			transaction.commit();
			close();
			return admin;
		}
		transaction.commit();
		close();
		return null;
	}

	

}
