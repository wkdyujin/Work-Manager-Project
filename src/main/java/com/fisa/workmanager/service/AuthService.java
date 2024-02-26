package com.fisa.workmanager.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.dto.AuthDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.repository.AuthRepository;

@Service
public class AuthService {
	
	private AuthRepository authRepo;
	
	public AuthService(AuthRepository authRepo) {
		this.authRepo = authRepo;
	}
	
	public AuthDto authenticate(String ename, String password) {
		Optional<Employee> result = authRepo.findByEnameAndPassword(ename, password);
		if (result.isPresent()) {
			Employee employee = result.get();
			return new AuthDto(employee.getId(), employee.getRole().name());
		} else {
			throw new RuntimeException("아이디 혹은 비밀번호를 확인해 주세요");
		}
	}
}
