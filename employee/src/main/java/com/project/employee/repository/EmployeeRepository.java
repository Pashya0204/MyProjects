package com.project.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.employee.pojo.EmployeePOJO;

@Repository
public class EmployeeRepository {
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

	@SuppressWarnings("unused")
	public EmployeePOJO addEmployee(String name, String email, long contact, String role, double salary) {
		open();
		transaction.begin();
		EmployeePOJO employee = new EmployeePOJO();
		employee.setName(name);
		employee.setEmail(email);
		employee.setContact(contact);
		employee.setDesignation(role);
		employee.setSalary(salary);
		manager.persist(employee);
		transaction.commit();
		close();
		return employee;
	}

	public EmployeePOJO searchEmployee(int id) {
		open();
		transaction.begin();
		EmployeePOJO employee = new EmployeePOJO();
		employee = manager.find(EmployeePOJO.class, id);
		transaction.commit();
		close();
		return employee;
	}

	public List<EmployeePOJO> serachAllEmployee() {
		open();
		transaction.begin();
		jpql = "from EmployeePOJO";
		query = manager.createQuery(jpql);
		List<EmployeePOJO> employees = query.getResultList();
		transaction.commit();
		close();
		return employees;
	}

	public EmployeePOJO removeEmployee(int id) {
	open();
	transaction.begin();
	
	EmployeePOJO employee = manager.find(EmployeePOJO.class, id);
	manager.remove(employee);
	
	transaction.commit();
	close();
		return employee;
	}

	public EmployeePOJO updateEmployee(int id,String name, String email, long contact, String designation, double salary) {
		open();
		transaction.begin();
		EmployeePOJO employee = manager.find(EmployeePOJO.class, id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setContact(contact);
		employee.setDesignation(designation);
		employee.setSalary(salary);
		manager.persist(employee);
		transaction.commit();
		close();
		return null;
	}
}