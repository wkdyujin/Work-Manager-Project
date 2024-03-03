package com.fisa.workmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisa.workmanager.dto.EmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/list")
	public String getUserList(Model model) {
		List<Employee> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "user/list";
	}
	
	@GetMapping("/{id}")
	public String getUserById(@PathVariable("id") Long id, Model model) {
		EmployeeDto empDto = userService.getUser(id);
		model.addAttribute("user", empDto);
		return "user/detail";
	}

}
