package com.fisa.workmanager.dto;

import java.util.Date;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.PeerEvaluation;
import com.fisa.workmanager.model.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeerEvalDto {
	private Project project;
    private Employee evaluatee;
    private Employee evaluator;
    private Integer score;
    private String comment;
    
    public PeerEvaluation toEntity() {
    	return PeerEvaluation.builder()
    			.project(this.project)
    			.evaluatee(this.evaluatee)
    			.evaluator(this.evaluator)
    			.score(this.score)
    			.comment(this.comment)
    			.build();
    }
}
