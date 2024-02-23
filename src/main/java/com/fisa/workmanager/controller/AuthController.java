package com.fisa.workmanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisa.workmanager.dto.LoginDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginDto loginDto, Model model) {
		try {
			Long id = authService.authenticate(loginDto.getEname(), loginDto.getPassword());
			System.out.println(id);
			return "index";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "user/login";
		}
	}
}
