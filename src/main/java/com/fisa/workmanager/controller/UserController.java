package com.fisa.workmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/")
	public List<Employee> getUserList() {
		List<Employee> userList = userService.getUserList();
		return userList;
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getUserById(@PathVariable("id") Long id) {
		EmployeeDto empDto = userService.getUser(id);
		return empDto;
	}

}
