package com.fisa.workmanager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fisa.workmanager.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
