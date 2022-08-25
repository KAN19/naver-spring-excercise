package com.ronald.naverexercise.payload.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronald.naverexercise.entity.Department;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
public class EmployeeDto {
    private String employeeId;
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private String gender;
    private Long departmentId;
}
