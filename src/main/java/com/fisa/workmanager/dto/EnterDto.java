package com.fisa.workmanager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter 
@NoArgsConstructor
public class EnterDto {
	private Long pid;
	private List<EnterEmployeeDto> enterEmpList = new ArrayList<>(); // 초기화

	@ToString
	@Getter @Setter 
	@NoArgsConstructor
	public static class EnterEmployeeDto { // 내부 클래스로 정의
		private Long eid;
		private String role;

		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date enterDate;
	}
}