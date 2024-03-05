package com.fisa.workmanager;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fisa.workmanager.dto.EmployeeDto;
import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	void 전체유저조회() {
		List<Employee> empList = userService.getUserList();
		System.out.println(empList);
	}
	
	@Test
	void 특정유저조회() {
		EmployeeDto empDto = userService.getUserInfo(1L);
	}
	
	@Test
	void 유저참여프로젝트목록조회() {
		List<ProjectDto> pDto = userService.getUserProjectList(1L);
		for (ProjectDto dto: pDto) {
			System.out.println(dto.toString());
		}
	}

}
