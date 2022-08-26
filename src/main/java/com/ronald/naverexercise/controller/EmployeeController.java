package com.ronald.naverexercise.controller;

import com.ronald.naverexercise.payload.BaseResponse;
import com.ronald.naverexercise.payload.dto.employee.EmployeeDto;
import com.ronald.naverexercise.entity.Employee;
import com.ronald.naverexercise.payload.dto.employee.EmployeeWithDepartmentDto;
import com.ronald.naverexercise.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        List<EmployeeDto> employees = employeeService.getEmployees()
                .stream().map((employee -> modelMapper.map(employee, EmployeeDto.class))).collect(Collectors.toList());
        return ResponseEntity.ok().body(BaseResponse.success(employees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return ResponseEntity.ok().body(BaseResponse.success(employeeDto));
    }

    @GetMapping("/with-department-ob/{id}")
    public ResponseEntity<?> getEmployeeWithDepById(@PathVariable("id") Long employeeId) {
        EmployeeWithDepartmentDto employee = employeeService.getEmployeesWithDepartmentObject(employeeId);
        return ResponseEntity.ok().body(BaseResponse.success(employee));
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {

        Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);

        Employee employee = employeeService.saveEmployee(employeeRequest);

        EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);

        return ResponseEntity.ok().body(BaseResponse.success(employeeResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {

        Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);

        Employee employee = employeeService.updateEmployee(employeeRequest, employeeId);

        EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);

        return ResponseEntity.ok().body(BaseResponse.success(employeeResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> depleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().body(BaseResponse.success(null, "Delete successfully!"));
    }

}
