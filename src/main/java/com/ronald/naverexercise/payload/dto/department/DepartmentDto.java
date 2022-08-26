package com.ronald.naverexercise.payload.dto.department;

import com.ronald.naverexercise.entity.Employee;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class DepartmentDto {

    private Long departmentId;
    private String departmentName;
    private String description;

}
