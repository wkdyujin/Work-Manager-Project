package com.fisa.workmanager.model.entity;

import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import com.fisa.workmanager.dto.EmployeeDto;

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
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
	
	public EmployeeDto toDto() {
		return EmployeeDto.builder()
				.id(this.id)
				.name(this.name)
				.ename(this.ename)
				.password(this.password)
				.role(this.role.toString())
				.gender(this.gender.toString())
				.birth(Optional.ofNullable(this.birth)
                        .map(b -> b.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                        .orElse(null))
				.email(this.email)
				.tel(this.tel)
				.location(this.location)
				.salary(this.salary)
				.hiredate(Optional.ofNullable(this.hiredate)
                        .map(b -> b.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                        .orElse(null))
				.build();
	}
}
