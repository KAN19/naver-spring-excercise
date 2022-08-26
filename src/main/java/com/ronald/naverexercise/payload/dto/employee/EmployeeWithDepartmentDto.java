package com.ronald.naverexercise.payload.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronald.naverexercise.entity.Department;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class EmployeeWithDepartmentDto {
    private String employeeId;
    @NotBlank(message = "Khong dc de trong")
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private String gender;
    private Department department;

}
