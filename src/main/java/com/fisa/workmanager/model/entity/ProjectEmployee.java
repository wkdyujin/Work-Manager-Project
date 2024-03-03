package com.fisa.workmanager.model.entity;

import java.util.Date;

import com.fisa.workmanager.model.entity.id.ProjectEmployeeId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@IdClass(ProjectEmployeeId.class)
public class ProjectEmployee {
	@Id
	@ManyToOne
	@JoinColumn(name = "p_id", referencedColumnName = "p_id")
	private Project project;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "e_id", referencedColumnName = "e_id")
	private Employee employee;
	
	private String role;
	private Date enterDate;
}