package com.fisa.workmanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.dto.EnterDto;
import com.fisa.workmanager.dto.EnterDto.EnterEmployeeDto;
import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.Project;
import com.fisa.workmanager.model.entity.ProjectEmployee;
import com.fisa.workmanager.repository.AuthRepository;
import com.fisa.workmanager.repository.ProjectEmployeeRepository;
import com.fisa.workmanager.repository.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProjectService {
	private ProjectRepository projectRepo;
	private ProjectEmployeeRepository projectEmployeeRepo;
	private AuthRepository authRepo;
	
	ProjectService(ProjectRepository projectRepo, ProjectEmployeeRepository projectEmployeeRepo, AuthRepository authRepo) {
		this.projectRepo = projectRepo;
		this.projectEmployeeRepo = projectEmployeeRepo;
		this.authRepo= authRepo;
	}
	
	@Transactional
	public Long createProject(ProjectDto projectDto, Long id) {
		// 1. 프로젝트 생성
		Project project = projectRepo.save(projectDto.toEntity());
		
		// 2. 현재 사용자 정보 조회
		Optional<Employee> result = authRepo.findById(id);
		if (!result.isPresent()) {
			throw new RuntimeException("다시 시도해 주세요");
		}
		Employee employee = result.get();
		
		// 2. 현재 사용자(팀장)을 PM으로 프로젝트에 투입
		ProjectEmployee projectEmployee = new ProjectEmployee().builder()
				.project(project)
				.employee(employee)
				.enterDate(projectDto.getStartDate())
				.role("PM")
				.build();
		projectEmployeeRepo.save(projectEmployee);
		
		return project.getId();
	}

	// 전체 project x employee 조회
	public List<ProjectEmployeeDto> getProjectEmployee(Long pid) {
		List<ProjectEmployeeDto> peDtoList = projectEmployeeRepo.findByProjectId(pid);
		return peDtoList;
	}

	// 현재 유저 제외 project x employee 조회
	public List<ProjectEmployeeDto> getProjectEmployee(Long pid, Long eid) {
		List<ProjectEmployeeDto> peDtoList = projectEmployeeRepo.findProEmpWithoutPm(pid, eid);
		return peDtoList;
	}

	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}

	public ProjectDto getProject(Long id) {
		Optional<Project> result = projectRepo.findById(id);
		if (result.isPresent()) {
			return result.get().toDto();
		}
		throw new RuntimeException("존재하지 않는 프로젝트입니다.");
	}

	@Transactional
	public EnterDto enterEmp(EnterDto enterDto) {
		Project project = projectRepo.findById(enterDto.getPid())
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
		
		List<ProjectEmployee> projectEmployees = new ArrayList<>();
		for (EnterEmployeeDto empDto: enterDto.getEnterEmpList()) {
			Employee employee = authRepo.findById(empDto.getEid())
	            .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + empDto.getEid()));
	        ProjectEmployee projectEmployee = new ProjectEmployee();
	        projectEmployee.setProject(project);
	        projectEmployee.setEmployee(employee);
	        projectEmployee.setRole(empDto.getRole());
	        projectEmployee.setEnterDate(empDto.getEnterDate());
	        projectEmployees.add(projectEmployee);
		}
		projectEmployeeRepo.saveAll(projectEmployees);
	    return enterDto;
	}
	
	public ProjectEmployeeDto getProjEmp(Long pid, Long eid) { // 해당 프로젝트 참여여부 검증
		System.out.println(pid + " " + eid);
		Optional<ProjectEmployeeDto> res = projectEmployeeRepo.findDtoByEidAndPid(eid, pid);
		if (res.isPresent()) {
			System.out.println(res.get().getEid());
			return res.get();
		} else {
			System.out.println(res);
			throw new RuntimeException("해당 프로젝트에 참여하지 않은 사원입니다.");
		}
	}
}
