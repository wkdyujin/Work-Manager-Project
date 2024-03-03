package com.fisa.workmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fisa.workmanager.dto.AuthDto;
import com.fisa.workmanager.dto.LoginDto;
import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.model.entity.Project;
import com.fisa.workmanager.service.ProjectService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private ProjectService projectService;
	
	ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping("/register")
	public String createProject() {
		return "project/register";
	}
	
	@PostMapping("/register")
	public String createProejct(@ModelAttribute("projectForm") ProjectDto projectDto, HttpSession session) {
		AuthDto authDto = (AuthDto) session.getAttribute("session");
		Long projectId = projectService.createProject(projectDto, authDto.getId());
		return "redirect:/project/detail/" + projectId;
	}
	
	@GetMapping("/detail/{id}")
	public String getProject(@PathVariable("id") Long id) {
		return "project/detail";
	}
}
