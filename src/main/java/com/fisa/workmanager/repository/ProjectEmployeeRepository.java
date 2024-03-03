package com.fisa.workmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisa.workmanager.model.entity.ProjectEmployee;
import com.fisa.workmanager.model.entity.id.ProjectEmployeeId;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, ProjectEmployeeId> {

}
