package com.fisa.workmanager.service;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository urepo;
	
	public UserService(UserRepository urepo) {
		this.urepo = urepo;
	}
}
