package com.fisa.workmanager.dto;

import java.time.LocalDate;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.Employee.GenderType;
import com.fisa.workmanager.model.entity.Employee.RoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String gender;
    private String role;
    private String email;
    private LocalDate birth;
    private String tel;
    private String location;
    private Double salary;
    private LocalDate hiredate;
    // 기타 필드 및 메소드 생략

    public Employee toEntity(String empId) {
        return Employee.builder()
                .name(this.name)
                .ename(empId)
                .password(empId)
                .gender(GenderType.valueOf(this.gender))
                .role(RoleType.valueOf(this.role))
                .email(this.email)
                .birth(java.sql.Date.valueOf(this.birth))
                .tel(this.tel)
                .location(this.location)
                .salary(this.salary)
                .hiredate(java.sql.Date.valueOf(this.hiredate))
                .build();
    }
}
