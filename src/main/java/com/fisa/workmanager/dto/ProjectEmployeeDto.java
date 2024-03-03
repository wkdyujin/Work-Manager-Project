package com.fisa.workmanager.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class ProjectEmployeeDto {
	// project Entity
	private Long pid;
	private String pname;
	private String description;
	private String client;
	private double budget;
	private Date startDate;
	private Date deadline;
	
	// employee Entity
	private Long eid;
	private String name;
	
	// projcetEmployee Entity
	private String role;
	private Date enterDate;
	
}
