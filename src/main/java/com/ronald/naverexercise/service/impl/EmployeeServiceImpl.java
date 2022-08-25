package com.ronald.naverexercise.service.impl;

import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.entity.Employee;
import com.ronald.naverexercise.repository.DepartmentRepository;
import com.ronald.naverexercise.repository.EmployeeRepository;
import com.ronald.naverexercise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findEmployeeByEmployeeId(employeeId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(Employee employeeRequest, Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new IllegalArgumentException("Khong tim thay employee" + employeeId)
        );

        Optional<Department> department = departmentRepository.findById(employeeRequest.getDepartment().getDepartmentId());
        if(department.isEmpty()) {
            throw new IllegalArgumentException("Khong tim thay department " + employeeRequest.getDepartment().getDepartmentId());
        }

        employee.setGender(employeeRequest.getGender());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setName(employeeRequest.getName());
        employee.setDepartment(department.get());

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Khong tim thay employee" + id)
        );

        employeeRepository.delete(employee);
    }
}
