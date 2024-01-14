package com.project.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employee.pojo.EmployeePOJO;
import com.project.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public EmployeePOJO addEmployee(String name, String email, long contact, String role, double salary) {
		EmployeePOJO employee = repository.addEmployee(name, email, contact, role, salary);
		return employee;
	}

	public EmployeePOJO searchEmp(int id) {
		EmployeePOJO employee = repository.searchEmployee(id);
		return employee;
	}

	public List<EmployeePOJO> searchAllEmployee() {
		List<EmployeePOJO> employees = repository.serachAllEmployee();
		return employees;
	}

	public EmployeePOJO removeEmployee(int id) {
		EmployeePOJO employee = repository.removeEmployee(id);
		return employee;
	}

	public EmployeePOJO updateEmployee(int id,String name, String email, long contact, String designation, double salary) {
		EmployeePOJO employee = repository.updateEmployee(id,name,email,contact,designation,salary);
		return null;
	}
}
