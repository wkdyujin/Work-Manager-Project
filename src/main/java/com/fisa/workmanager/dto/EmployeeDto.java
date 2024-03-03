package com.fisa.workmanager.dto;

import java.time.LocalDate;
import java.util.Optional;

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
                .name(this.name)
                .ename(empId)
                .password(empId)
                .gender(genderType)
                .role(roleType)
                .email(this.email)
                .birth(Optional.ofNullable(this.birth).map(java.sql.Date::valueOf).orElse(null))
                .tel(this.tel)
                .location(this.location)
                .salary(this.salary)
                .hiredate(Optional.ofNullable(this.hiredate).map(java.sql.Date::valueOf).orElse(null))
                .build();
    }
}
