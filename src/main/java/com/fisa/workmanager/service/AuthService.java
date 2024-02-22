package com.fisa.workmanager.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.repository.AuthRepository;

@Service
public class AuthService {
	
	private AuthRepository authRepo;
	
	public AuthService(AuthRepository erepo) {
		this.authRepo = authRepo;
	}
	
	public Optional<Employee> authenticate(String ename, String password) {
		return authRepo.findByEnameAndPassword(ename, password);
	}
}
