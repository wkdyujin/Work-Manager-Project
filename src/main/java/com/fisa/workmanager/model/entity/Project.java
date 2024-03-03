package com.fisa.workmanager.model.entity;

import java.util.Date;
import java.util.List;

import com.fisa.workmanager.dto.ProjectDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private Long id;
	
	private String pname;
	private String description;
	private String client;
	private Date startDate;
	private Date deadline;
	private double budget;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	List<PeerEvaluation> peerEval;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	List<PmCustomerEvaluation> pmCusEval;
	
	public ProjectDto toDto() {
		return ProjectDto.builder()
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
