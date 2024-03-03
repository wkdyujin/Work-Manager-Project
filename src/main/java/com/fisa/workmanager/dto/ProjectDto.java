package com.fisa.workmanager.dto;

import java.util.Date;

import com.fisa.workmanager.model.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ProjectDto {
	private Long id;
	private String pname;
	private String description;
	private String client;
	private Date startDate;
	private Date deadline;
	private double budget;

	public Project toEntity() {
		return Project.builder()
				.id(this.id)
				.pname(this.pname)
				.description(this.description)
				.client(this.client)
				.startDate(this.startDate)
				.deadline(this.deadline)
				.budget(this.budget)
				.build();
	}
}
