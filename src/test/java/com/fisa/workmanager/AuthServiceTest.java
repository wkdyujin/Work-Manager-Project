package com.fisa.workmanager;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fisa.workmanager.dto.EmployeeDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.service.AuthService;
import com.fisa.workmanager.service.UserService;

@SpringBootTest
public class AuthServiceTest {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	UserService userService;

	@Test
	void 유저추가() {
		// given
		EmployeeDto emp = new EmployeeDto();
		emp.setName("user1");
//		emp.setRole("USER");
//		emp.setGender("MALE");
//		emp.setBirth(LocalDate.of(1990, 1, 1));
//		emp.setHiredate(LocalDate.of(2023, 1, 1));
		
		// when
		authService.createUser(emp, "2408");
		
		// then
		// 저장한 User 레포지토리에 있는 검증
		EmployeeDto findEmp = userService.getUser((long) 1);
		assertThat(emp.getName()).isEqualTo(findEmp.getName());
	}
}
