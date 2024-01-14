package com.project.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.employee.pojo.AdminPOJO;
import com.project.employee.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

//Admin create page
	@GetMapping("/create")
	public String createAdmin() {
		return "Admin";
	}

//Admin Creation
	@PostMapping("/create")
	public String addAdmin(@RequestParam String username, @RequestParam String password, ModelMap map) {
		if (username != "" & password != "") {
			AdminPOJO admin = adminService.add(username, password);
			if (admin != null) {
				map.addAttribute("msg", "Account Created Sucessfully.....");
				return "Login";
			}
		}
		map.addAttribute("msg", "Account Not Created....");
		return "Login";
	}

//login home page
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password,HttpServletRequest request, ModelMap map) {
		AdminPOJO admin = adminService.login(username, password);
		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", admin);
			return "Home";
		}
		map.addAttribute("msg", "Invalid username or password...");
		return "Login";
	}
	//Logout
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		map.addAttribute("msg", "Logged out Successfully...");
		session.invalidate();
		return "Login";
	}
}
