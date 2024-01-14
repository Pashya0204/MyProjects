package com.project.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.project.employee.pojo.AdminPOJO;
import com.project.employee.pojo.EmployeePOJO;
import com.project.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Home";
		}
		map.addAttribute("msg", "Please proceed to Login..");
		return "Login";
	}

	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Add";
		}
		map.addAttribute("msg", "Please proceed to Login..");
		return "Login";
	}

	@PostMapping("/add")
	public String add(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String role, @RequestParam double salary, ModelMap map,@SessionAttribute(name = "login",required = false)AdminPOJO login) {
		if (login !=null) {
			EmployeePOJO employee = service.addEmployee(name, email, contact, role, salary);
			if (employee != null) {
				map.addAttribute("msg", "Employee Added Suceessfulyy !");
				return "Add";
			} else {
				map.addAttribute("msg", "Employee Data Not Added Suceessfulyy !");
				return "Add";
			}
		}
		map.addAttribute("msg","Please proceed to Login..");
		return "Login";
	}

	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			return "Search";
		}
		map.addAttribute("msg", "Please proceed to Login..");
		return "Login";

	}

	@PostMapping("/search")
	public String searchEmp(@SessionAttribute(name = "login", required = false) AdminPOJO login, @RequestParam int id,
			ModelMap map) {
		if (login != null) {
			EmployeePOJO employee = service.searchEmp(id);
			if (employee != null) {
				map.addAttribute("emp", employee);
				return "Search";
			} else {
				map.addAttribute("msg", "Data Not found !!");
				return "Search";
			}
		}
		map.addAttribute("msg", "Please proceed to Login..");
		return "Login";
	}

	@GetMapping("/remove")
	public String remove(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
		if (login != null) {
			List<EmployeePOJO> employee = service.searchAllEmployee();
			map.addAttribute("empList", employee);
			return "Remove";
		}
		map.addAttribute("msg","Please proceed to Login..");
		return "Login";
	}

	@PostMapping("/remove")
	public String removePage(@SessionAttribute(name = "login",required = false)AdminPOJO login,@RequestParam int id, ModelMap map) {
		if (login != null) {
			EmployeePOJO emp = service.searchEmp(id);
			if (emp != null) {
				EmployeePOJO employee = service.removeEmployee(id);
				map.addAttribute("msg", "Data Removed Successfully !");
				List<EmployeePOJO> employee1 = service.searchAllEmployee();
				map.addAttribute("empList", employee1);
				return "Remove";
			} else {
				List<EmployeePOJO> employee1 = service.searchAllEmployee();
				map.addAttribute("empList", employee1);
				map.addAttribute("msg", "Data Not Found/Removed  !!");
				return "Remove";
			}
		}
		map.addAttribute("msg","Please proceed to Login..");
		return "Login";
	}

	@GetMapping("/update")
	public String update(@SessionAttribute(name = "login",required = false)AdminPOJO login,ModelMap map) {
		if (login != null) {
			List<EmployeePOJO> employees = service.searchAllEmployee();
			map.addAttribute("empList", employees);
			return "Update";
		}
		map.addAttribute("msg","Please proceed to Login..");
		return "Login";
	}

	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login",required = false)AdminPOJO login,@RequestParam int id, ModelMap map) {
		if (login != null) {
			EmployeePOJO employee = service.searchEmp(id);
			if (employee != null) {
				map.addAttribute("emp", employee);
				map.addAttribute("msg", "Data Found !!");
				return "Update";
			}
			map.addAttribute("msg", "Data Not Found !!");
			List<EmployeePOJO> employees = service.searchAllEmployee();
			map.addAttribute("empList", employees);
			return "Update";
		}
		map.addAttribute("msg","Please proceed to Login..");
		return "Login";
	}

	@PostMapping("/updateData")
	public String updatePage(@SessionAttribute(name = "login",required = false)AdminPOJO login,@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long contact, @RequestParam String designation, @RequestParam double salary, ModelMap map) {
		if (login != null) {
			EmployeePOJO employee = service.searchEmp(id);
			if (employee != null) {
				employee = service.updateEmployee(id, name, email, contact, designation, salary);
				map.addAttribute("msg", "Data Updated Sucessfully !!");
				List<EmployeePOJO> employees = service.searchAllEmployee();
				map.addAttribute("empList", employees);
				return "Update";
			}
			map.addAttribute("msg", "Data Not Updated !!");
			return "Update";
		}
		map.addAttribute("msg","Please proceed to Login..");
		return "Login";
	}
}
