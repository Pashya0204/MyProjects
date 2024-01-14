package com.project.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.student.pojo.StudentPOJO;
import com.project.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(String name, String email, double percent, long contact) {
		StudentPOJO student = repository.addStudent(name, email, percent, contact);
		return student;
	}

	public StudentPOJO searchStudent(int id) {
		StudentPOJO student = repository.searchStudent(id);
		return student;
	}

	public List<StudentPOJO> searchAllStudents() {
		List<StudentPOJO> students = repository.searchAllStudent();
		return students;
	}

	public StudentPOJO removeStudent(int id) {
		StudentPOJO student = repository.removeStudent(id);
		return student;
	}

	public void updateStudent(int id, String name, String email, long contact, double percent) {
		repository.updateStudent(id, name, email, contact, percent);

	}

}
