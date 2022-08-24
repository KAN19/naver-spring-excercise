package com.ronald.naverexercise.dto;

import com.ronald.naverexercise.entity.Department;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class EmployeeDto {
    private String employeeId;
    private String name;
    private Date birthDate;
    private String gender;
    private Long departmentId;
}
