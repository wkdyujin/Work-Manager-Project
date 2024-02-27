package com.fisa.workmanager.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private Long id;
	private String name;
	private String ename;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;

	private String email;
	private Date birth;
	private String tel;
	private String location;
	private Double salary;
	private Date hiredate;
	
	public enum GenderType {
		FEMALE, MALE
    }
	
	public enum RoleType {
        USER, MANAGER, ADMIN
    }
}
