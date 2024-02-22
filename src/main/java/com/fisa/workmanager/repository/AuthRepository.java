package com.fisa.workmanager.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisa.workmanager.model.entity.Employee;

@Repository
public interface AuthRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findByEnameAndPassword(String ename, String password);
}
