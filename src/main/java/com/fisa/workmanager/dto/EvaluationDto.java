package com.fisa.workmanager.dto;

import com.fisa.workmanager.model.entity.PmCustomerEvaluation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class EvaluationDto {
	private Integer score;
	private String comment;
	
	public PmCustomerEvaluation toEntity() {
		return PmCustomerEvaluation.builder()
				.score(this.score)
				.comment(this.comment)
				.build();
	}
}
