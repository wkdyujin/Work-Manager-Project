package com.fisa.workmanager.dto;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation;
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
	private Integer score;
	private String comment;
	private EvaluationType evalType;
	
	public PmCustomerEvaluation toEntity() {
		return PmCustomerEvaluation.builder()
				.project(this.project)
				.evaluatee(this.employee)
				.score(this.score)
				.comment(this.comment)
				.evalType(this.evalType)
				.build();
	}
}
