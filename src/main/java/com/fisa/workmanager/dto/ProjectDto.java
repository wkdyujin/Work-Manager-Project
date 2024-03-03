package com.fisa.workmanager.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class ProjectDto {
	private Long id;
	private String pname;
	private String description;
	private String client;
	private double budget;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;

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
