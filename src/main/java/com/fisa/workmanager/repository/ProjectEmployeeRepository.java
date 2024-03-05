package com.fisa.workmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.model.entity.Project;
import com.fisa.workmanager.model.entity.ProjectEmployee;
import com.fisa.workmanager.model.entity.id.ProjectEmployeeId;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, ProjectEmployeeId> {

	// JPQL을 사용하여 Project, ProjectEmployee, Employee 조인
    @Query("SELECT new com.fisa.workmanager.dto.ProjectEmployeeDto(pe.project.id, pe.project.pname, pe.project.description, pe.project.client, pe.project.budget, pe.project.startDate, pe.project.deadline, pe.employee.id, pe.employee.ename, pe.employee.name, pe.role, pe.enterDate) " +
           "FROM ProjectEmployee pe " +
           "WHERE pe.project.id = :projectId")
    List<ProjectEmployeeDto> findByProjectId(@Param("projectId") Long projectId);
    
    @Query("SELECT new com.fisa.workmanager.dto.ProjectEmployeeDto(pe.project.id, pe.project.pname, pe.project.description, pe.project.client, pe.project.budget, pe.project.startDate, pe.project.deadline, pe.employee.id, pe.employee.ename, pe.employee.name, pe.role, pe.enterDate) " +
            "FROM ProjectEmployee pe " +
            "WHERE pe.project.id = :projectId AND pe.employee.id != :empId")
     List<ProjectEmployeeDto> findProEmpWithoutPm(@Param("projectId") Long projectId, @Param("empId") Long empId);
    
    @Query("SELECT new com.fisa.workmanager.dto.ProjectEmployeeDto(pe.project.id, pe.project.pname, pe.project.description, pe.project.client, pe.project.budget, pe.project.startDate, pe.project.deadline, pe.employee.id, pe.employee.ename, pe.employee.name, pe.role, pe.enterDate) "
    		+ "FROM ProjectEmployee pe "
    		+ "WHERE pe.employee.id = :eid AND pe.project.id = :pid")
    Optional<ProjectEmployeeDto> findDtoByEidAndPid(@Param("eid") Long eid, @Param("pid") Long pid);
    
    @Query("SELECT new com.fisa.workmanager.dto.ProjectDto(pe.project.id, pe.project.pname, pe.project.description, pe.project.client, pe.project.budget, pe.project.startDate, pe.project.deadline) " +
    	       "FROM ProjectEmployee pe " +
    	       "WHERE pe.employee.id = :eid")
	List<ProjectDto> findProjectsByEmployeeId(@Param("eid") Long employeeId);


}
