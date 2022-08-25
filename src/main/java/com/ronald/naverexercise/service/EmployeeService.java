package com.ronald.naverexercise.service;

import com.ronald.naverexercise.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeById(Long employeeId);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long employeeId);

    void deleteEmployee(Long id);

}
