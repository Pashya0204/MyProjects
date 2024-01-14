package com.project.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employee.pojo.AdminPOJO;
import com.project.employee.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public AdminPOJO add(String username, String password) {
		AdminPOJO admin = adminRepository.add(username, password);
		return admin;
	}

	public AdminPOJO login(String username, String password) {
		AdminPOJO admin = adminRepository.login(username, password);
		return admin;
		
	}

}
