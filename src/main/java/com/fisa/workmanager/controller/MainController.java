package com.fisa.workmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fisa.workmanager.annotation.CheckLogin;
import com.fisa.workmanager.dto.AuthDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	@CheckLogin
	public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        AuthDto dto = (AuthDto) session.getAttribute("session");
        String role = dto.getRole();

        // 세션에서 로그인 정보를 확인하여 리디렉션
        if ("ADMIN".equals(role)) {
            return "redirect:/user/list";
        } else if ("MANAGER".equals(role) || "USER".equals(role)) {
            return "redirect:/project/list";
        } else {
            // role이 없거나 예상치 못한 값일 경우, index 페이지로 리디렉션
            return "redirect:/";
        }
    }

}
