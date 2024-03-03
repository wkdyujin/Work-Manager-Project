package com.fisa.workmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.dto.EmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.repository.AuthRepository;

@Service
public class UserService {
	private AuthRepository authRepo;
	
	UserService(AuthRepository authRepo) {
		this.authRepo = authRepo;
	}

	public List<Employee> getUserList() {
		List<Employee> empList = authRepo.findAll();
		return empList;
	}
	
	public EmployeeDto getUser(Long id) {
		Optional<Employee> result = authRepo.findById(id);
		if (result.isPresent()) {
			Employee emp = result.get();
			return emp.toDto();
		}
		throw new RuntimeException("존재하지 않는 사용자입니다");
	}
}
