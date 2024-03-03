package com.fisa.workmanager.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.Employee.GenderType;
import com.fisa.workmanager.model.entity.Employee.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Long id;
	private String ename;
	private String password;
    private String name;
    private GenderType gender;
    private RoleType role;
    private String email;
    private String tel;
    private String location;
    private Double salary;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    public Employee toEntity() {

        return Employee.builder()
        		.id(this.id)
                .name(this.name)
                .gender(this.gender)
                .role(this.role)
                .email(this.email)
                .birth(this.birth)
                .tel(this.tel)
                .location(this.location)
                .salary(this.salary)
                .hiredate(this.hiredate)
                .build();
    }
}
