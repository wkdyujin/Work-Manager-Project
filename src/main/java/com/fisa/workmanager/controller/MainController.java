package com.fisa.workmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fisa.workmanager.annotation.CheckLogin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	@CheckLogin
	public String index(HttpServletRequest request) {
		// 세션에서 로그인 정보를 확인
		return "index";
	}

}
