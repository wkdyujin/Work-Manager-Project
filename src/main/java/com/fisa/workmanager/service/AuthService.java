package com.fisa.workmanager.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.repository.AuthRepository;

@Service
public class AuthService {
	
	private AuthRepository authRepo;
	
	public AuthService(AuthRepository authRepo) {
		this.authRepo = authRepo;
	}
	
	public Long authenticate(String ename, String password) {
		Optional<Employee> result = authRepo.findByEnameAndPassword(ename, password);
		if (result.isPresent()) {
			Employee selected = result.get();
			return selected.getId();
		}
		throw new RuntimeException("로그인 실패");
	}
}
