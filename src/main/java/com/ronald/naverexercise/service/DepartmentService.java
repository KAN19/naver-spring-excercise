package com.ronald.naverexercise.service;

import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.payload.dto.department.DepartmentWithNumEmpDto;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();

    Department getDepartmentById(Long departmentId);
    Department saveDepartment(Department department);

    Department putDepartment(Long id, Department departmentRequest);

    DepartmentWithNumEmpDto getDepartmentWithNumEmployees(Long id);

    void deleteDepartment(Long id);
}
