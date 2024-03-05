package com.fisa.workmanager.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisa.workmanager.annotation.CheckLogin;
import com.fisa.workmanager.dto.AuthDto;
import com.fisa.workmanager.dto.EnterDto;
import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.service.ProjectService;
import com.fisa.workmanager.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private ProjectService projectService;
	private UserService userService;
	
	private Long getEmpId(HttpSession session) {
		AuthDto dto = (AuthDto) session.getAttribute("session");
		return dto.getId();
	}
	
	ProjectController(ProjectService projectService, UserService userService) {
		this.projectService = projectService;
		this.userService = userService;
	}

	@CheckLogin
	@GetMapping("/register")
	public String createProject() {
		return "project/register";
	}

	@CheckLogin
	@PostMapping("/register")
	public String createProejct(@ModelAttribute("projectForm") ProjectDto projectDto, HttpSession session) {
		AuthDto authDto = (AuthDto) session.getAttribute("session");
		Long projectId = projectService.createProject(projectDto, authDto.getId());
		return "redirect:/project/detail/" + projectId;
	}

	@CheckLogin
	@GetMapping("/detail/{pid}")
	public String getProject(@PathVariable("pid") Long pid, Model model) {
		List<ProjectEmployeeDto> peDtoList = projectService.getProjectEmployee(pid);
		model.addAttribute("project", peDtoList);
		
		boolean isDeadlinePassed = peDtoList.get(0).getDeadline().before(new Date());
		model.addAttribute("isDeadlinePassed", isDeadlinePassed);
		return "project/detail";
	}

	@CheckLogin
	@GetMapping("/list")
	public String getProjectList(Model model) {
		model.addAttribute("projectList", projectService.getAllProject());
		return "project/list";
	}

	@CheckLogin
	@GetMapping("employee/{id}")
	public String enterForm(@PathVariable("id") Long id, Model model) {
		ProjectDto projectDto = projectService.getProject(id);
		List<Employee> empList = userService.getUserList();
		model.addAttribute("project", projectDto);
		model.addAttribute("empList", empList);
		return "project/enter";
	}

	@CheckLogin
	@PostMapping("employee/{id}")
	public String enterEmpToProj(@PathVariable("id") Long id, @ModelAttribute EnterDto enterDto) {
		enterDto.setPid(id);
		EnterDto resultDto = projectService.enterEmp(enterDto);
		return "redirect:/project/detail/" + id;
	}

	@CheckLogin
	@GetMapping("/csv/{id}")
	public void downloadCsv(@PathVariable("id") Long projectId, HttpServletResponse response, HttpSession session) throws IOException {
	    // 프로젝트 ID를 기반으로 참여 사원 목록 조회
	    List<ProjectEmployeeDto> employeeList = projectService.getProjectEmployee(projectId, getEmpId(session));

	    // CSV 파일 헤더 설정
	    response.setContentType("text/csv; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"employee-list.csv\"");

	    // CSV 파일 생성 및 데이터 작성
	    // CSV 헤더: 사원 이름(사번)에 따른 점수 및 피드백 컬럼 추가
	    response.getWriter().write("사원명(사번),점수(1~5),피드백\n");
	    for (ProjectEmployeeDto employee : employeeList) {
	        String employeeInfo = String.format("%s(%s)", employee.getName(), employee.getEname());
	        // 각 사원별로 점수와 피드백 컬럼은 비워둠
	        response.getWriter().write(String.format("%s,,\n", employeeInfo));
	    }

	    response.getWriter().flush();
	}
	
}
