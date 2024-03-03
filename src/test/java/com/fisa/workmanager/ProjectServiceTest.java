package com.fisa.workmanager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fisa.workmanager.dto.EmployeeDto;
import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.service.ProjectService;

@SpringBootTest
public class ProjectServiceTest {

	@Autowired
	ProjectService projectService;
	
	@Test
	void 프로젝트생성() {
		// given
		ProjectDto projectDto = new ProjectDto();
		projectDto.setPname("삼성전자프로젝트");
		
		// when
		projectService.createProject(projectDto, 14L);
		
		// then
	}
	
	@Test
	void 프로젝트조회() {
		List<ProjectEmployeeDto> peDtoList = projectService.getProjectEmployee(3L);
		System.out.println(peDtoList.toString());
	}
}
