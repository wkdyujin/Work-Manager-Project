package com.fisa.workmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.dto.EmployeeDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.repository.AuthRepository;
import com.fisa.workmanager.repository.ProjectEmployeeRepository;

@Service
public class UserService {
	private AuthRepository authRepo;
	private ProjectEmployeeRepository projectEmployeeRepo;
	
	UserService(AuthRepository authRepo, ProjectEmployeeRepository projectEmployeeRepo) {
		this.authRepo = authRepo;
		this.projectEmployeeRepo = projectEmployeeRepo;
	}
	
	private Employee checkUser(Long id) {
		Optional<Employee> result = authRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new RuntimeException("존재하지 않는 사용자입니다");
	}

	public List<Employee> getUserList() {
		List<Employee> empList = authRepo.findAll();
		return empList;
	}
	
	public EmployeeDto getUserInfo(Long eid) {
		EmployeeDto empDto = checkUser(eid).toDto();
		return empDto;
	}
	
	public List<ProjectEmployeeDto> getUserProjectList(Long eid) {
		List<ProjectEmployeeDto> projectList = projectEmployeeRepo.findProjectsByEmployeeId(eid);
		return projectList;
	}
}
