package com.fisa.workmanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisa.workmanager.dto.AuthDto;
import com.fisa.workmanager.dto.LoginDto;
import com.fisa.workmanager.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	public String login(@ModelAttribute("loginForm") LoginDto loginDto, HttpServletRequest request, Model model) {
		try {
			AuthDto authDto = authService.authenticate(loginDto.getEname(), loginDto.getPassword());
	        HttpSession session = request.getSession();
	        session.setAttribute("session", authDto);
	        System.out.println(authDto.getRole());
	        System.out.println(authDto.getId());
			return "redirect:/";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "user/login";
	}
}
