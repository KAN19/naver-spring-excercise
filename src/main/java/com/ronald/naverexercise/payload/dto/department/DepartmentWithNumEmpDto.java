package com.ronald.naverexercise.payload.dto.department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentWithNumEmpDto extends DepartmentDto{
    private int numEmployees;
}
