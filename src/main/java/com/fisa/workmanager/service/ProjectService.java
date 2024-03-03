package com.fisa.workmanager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.Project;
import com.fisa.workmanager.model.entity.ProjectEmployee;
import com.fisa.workmanager.repository.AuthRepository;
import com.fisa.workmanager.repository.ProjectEmployeeRepository;
import com.fisa.workmanager.repository.ProjectRepository;

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
				.enterDate(new Date())
				.role("PM")
				.build();
		projectEmployeeRepo.save(projectEmployee);
		
		return project.getId();
	}

	public List<ProjectEmployeeDto> getProjectEmployee(Long id) {
		List<ProjectEmployeeDto> peDtoList = projectEmployeeRepo.findByProjectId(id);
		return peDtoList;
	}

	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}
}
