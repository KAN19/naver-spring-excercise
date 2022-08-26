package com.ronald.naverexercise.service;

import com.ronald.naverexercise.entity.Employee;
import com.ronald.naverexercise.error.NotFoundException;
import com.ronald.naverexercise.payload.dto.employee.EmployeeWithDepartmentDto;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    EmployeeWithDepartmentDto getEmployeesWithDepartmentObject(Long id);

    Employee getEmployeeById(Long employeeId);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long employeeId);

    void deleteEmployee(Long id);

}
