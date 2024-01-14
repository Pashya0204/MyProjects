package com.project.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.student.pojo.AdminPOJO;
import com.project.student.service.AdminService;
@Controller
public class AdminController {
	@Autowired 
	private AdminService adminService;
	// Create Admin Controller
		@GetMapping("/create")
		public String admin() {
			return "Admin";
		}
	//Create admin controller
		@PostMapping("/create")
		public String createAdmmin(@RequestParam String username, @RequestParam String password, ModelMap map) {
			
			if (username != "" && password != "") {
			AdminPOJO	admin = adminService.addAdmin(username, password);
			if (admin !=null) {
				map.addAttribute("msg", "Account Created Successfully....");
				return "Login";

			}
							}
			map.addAttribute("msg", "Account Not Created....");
			return "Login";
		}
		//Login Controller
		@PostMapping("/login")
		public String login(@RequestParam String username,@RequestParam String password,ModelMap map,HttpServletRequest request) {
			if (username !="" && password !="") {
			AdminPOJO	admin=adminService.login(username,password);
			if(admin != null) {
				HttpSession session = request.getSession();
		session.setAttribute("login", admin);
				return "Home";}
			}
			map.addAttribute("msg", "Invalid username and password...");
			return "Login";
		}
}
