package com.fisa.workmanager.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private Long id;
	private String ename;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	
	private Date birth;
	private String tell;
	private String location;
	private Double salary;
	private Date hiredate;
	
	public enum GenderType {
        PM, CUSTOMER
    }
}
