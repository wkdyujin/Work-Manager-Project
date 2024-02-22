package com.fisa.workmanager.service;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository erepo;
	
	public EmployeeService(EmployeeRepository erepo) {
		this.erepo = erepo;
	}
}
