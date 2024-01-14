package com.project.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.student.pojo.AdminPOJO;
import com.project.student.repository.AdminRepository;

@Service
public class AdminService {
@Autowired
private AdminRepository  adminRepository;

public AdminPOJO addAdmin(String username, String password) {
AdminPOJO	admin=adminRepository.addAdmin(username,password);
	return admin;
}

public AdminPOJO login(String username, String password) {
AdminPOJO	admin =adminRepository.login(username,password);
	return admin;
}
}
