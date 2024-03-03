package com.fisa.workmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisa.workmanager.dto.AuthDto;
import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.service.ProjectService;

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
	public String getProject(@PathVariable("id") Long id, Model model) {
		List<ProjectEmployeeDto> peDtoList = projectService.getProjectEmployee(id);
		model.addAttribute("project", peDtoList);
		return "project/detail";
	}
	
	@GetMapping("/list")
	public String getProjectList(Model model) {
		model.addAttribute("projectList", projectService.getAllProject());
		return "project/list";
	}
}
