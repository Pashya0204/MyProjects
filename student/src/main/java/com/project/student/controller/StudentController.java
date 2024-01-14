package com.project.student.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.project.student.pojo.AdminPOJO;
import com.project.student.pojo.StudentPOJO;
import com.project.student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	

	// Home Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Please Login to proceed..");
		return "Login";
	}

	// AddPage Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Add";
		}
		map.addAttribute("msg", "Please Login to proceed..");
		return "Login";
	}

	// Post Data Add controller
	@PostMapping("/add")
	public String addStudent(@SessionAttribute(name = "login", required = false) AdminPOJO login,
			@RequestParam String name, @RequestParam String email, @RequestParam double percent,
			@RequestParam long contact, ModelMap map) {
		if (login != null) {
			StudentPOJO student = service.addStudent(name, email, percent, contact);
			if (student != null) {
				// Success Response
				map.addAttribute("msg", "Student Data Added Successfully");
				return "Add";
			}
//failure response
			map.addAttribute("msg", "Student Not Data Added Successfully");
			return "Add";
		}
		map.addAttribute("msg", "Please Login to proceed..");
		return "Login";
	}

	// Search Page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Search";
		}
		map.addAttribute("msg", "Please Login to proceed..");
		return "Login";

	}

	@PostMapping("/search")
	public String searchStudent(@SessionAttribute(name = "login", required = false) AdminPOJO login,
			@RequestParam int id, ModelMap map) {

		if (login != null) {
			StudentPOJO student = service.searchStudent(id);

			if (student != null) {
				map.addAttribute("msg", "Data Found !!");
				map.addAttribute("student", student);

				return "Search";
			} else {
				map.addAttribute("msg", "Data Not Found !!");
				return "Search";
			}
		}
		map.addAttribute("msg", "Please Login to proceed..");
		return "Login";
	}

	@GetMapping("/remove")
	public String remove(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			List<StudentPOJO> students = service.searchAllStudents();
			if (students != null) {
				map.addAttribute("studList", students);
				return "Remove";
			} else
				map.addAttribute("msg", "Data Not Found !!");
			return "Remove";

		}
		map.addAttribute("msg","Please Login to proceed..");
		return "Login";
	}

	@PostMapping("/remove")
	public String removePage(@SessionAttribute(name="login" ,required = false)AdminPOJO login ,@RequestParam int id, ModelMap map) {
	if (login != null) {
		StudentPOJO student = service.searchStudent(id);
		if (student != null) {
			student = service.removeStudent(id);
			map.addAttribute("msg", "Data removed Sucessfully !!");
			List<StudentPOJO> students = service.searchAllStudents();
			map.addAttribute("studList", students);
			return "Remove";
		}
		List<StudentPOJO> students = service.searchAllStudents();
		map.addAttribute("msg", "Data Not Removed !!");
		map.addAttribute("studList", students);
		return "Remove";
	}
	map.addAttribute("msg","Please Login to proceed..");
	return "Login";
	}

	@GetMapping("/update")
	public String update(@SessionAttribute(name="login" ,required = false)AdminPOJO login ,ModelMap map) {
	if (login != null) {
		List<StudentPOJO> students = service.searchAllStudents();
		if (students != null) {
			map.addAttribute("studList", students);
			return "Update";
		}

		return "Update";
	}
	map.addAttribute("msg","Please Login to proceed..");
	return "Login";
	}

	@PostMapping("/update")
	public String updatePage(@SessionAttribute(name="login" ,required = false)AdminPOJO login ,@RequestParam int id, ModelMap map) {
		if (login != null) {
			StudentPOJO student = service.searchStudent(id);
			if (student != null) {
				map.addAttribute("msg", "Data Found !!");
				map.addAttribute("student", student);
				return "Update";

			}
			map.addAttribute("msg", "Data Not Found !!");
			List<StudentPOJO> students = service.searchAllStudents();
			map.addAttribute("studList", students);
			return "Update";

		}	
		map.addAttribute("msg","Please Login to proceed..");
		return "Login";	
	}

	@PostMapping("/updateData")
	public String updateData(@SessionAttribute(name="login" ,required = false)AdminPOJO login ,@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long contact, @RequestParam double percent, ModelMap map) {
		if (login != null) {
			StudentPOJO student = service.searchStudent(id);
			if (student != null) {
				service.updateStudent(id, name, email, contact, percent);
				map.addAttribute("msg", "Record Found And Data Updated !!");
				List<StudentPOJO> students = service.searchAllStudents();
				map.addAttribute("studList", students);
				return "Update";
			}
			map.addAttribute("msg", "Data Not found !!");
			return "Update";
		}
		map.addAttribute("msg","Please Login to proceed..");
		return "Login";
	}

	// Logout Controller
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		map.addAttribute("msg", "Logged out Successfully...");
		session.invalidate();
		return "Login";
	}

}
