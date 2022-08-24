package com.ronald.naverexercise.controller;

import com.ronald.naverexercise.dto.EmployeeDto;
import com.ronald.naverexercise.entity.Employee;
import com.ronald.naverexercise.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        employeeDto.setDepartmentId(employee.getDepartment().getDepartmentId());

        return ResponseEntity.ok().body(employeeDto);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

        Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);
        Long departmentId = employeeDto.getDepartmentId();

        Employee employee = employeeService.saveEmployee(employeeRequest, departmentId);

        EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);
        employeeResponse.setDepartmentId(employee.getDepartment().getDepartmentId());

        return ResponseEntity.ok().body(employeeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {

        Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);
        Long departmentId = employeeDto.getDepartmentId();

        Employee employee = employeeService.updateEmployee(employeeRequest, departmentId, employeeId);

        EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);
        employeeResponse.setDepartmentId(employee.getDepartment().getDepartmentId());

        return ResponseEntity.ok().body(employeeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> depleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().body("Delete successful");
    }

}
