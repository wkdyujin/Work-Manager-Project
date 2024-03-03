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
    private String gender;
    private String role;
    private String email;
    private String tel;
    private String location;
    private Double salary;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    public Employee toEntity(String empId) {
        GenderType genderType;
        try {
            genderType = GenderType.valueOf(this.gender.toUpperCase());
        } catch (Exception e) {
            genderType = GenderType.MALE;
        }

        RoleType roleType;
        try {
            roleType = RoleType.valueOf(this.role.toUpperCase());
        } catch (Exception e) {
            roleType = RoleType.USER;
        }

        return Employee.builder()
        		.id(this.id)
                .name(this.name)
                .ename(empId)
                .password(empId)
                .gender(genderType)
                .role(roleType)
                .email(this.email)
                .birth(this.birth)
                .tel(this.tel)
                .location(this.location)
                .salary(this.salary)
                .hiredate(this.hiredate)
                .build();
    }
}
