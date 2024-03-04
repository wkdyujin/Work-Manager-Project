package com.fisa.workmanager.dto;

import java.util.Date;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.Project;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation.EvaluationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class PmCustomerEvalDto {
	private Project project;
	private Employee employee;
	private String role;
	private Date enterDate;
	private EvaluationType evalType;
}
