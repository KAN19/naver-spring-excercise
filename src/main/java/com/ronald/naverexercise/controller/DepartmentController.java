package com.ronald.naverexercise.controller;

import com.ronald.naverexercise.dto.DepartmentDto;
import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> people = departmentService.getDepartments();
        return ResponseEntity.ok().body(people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        Department departmentRequest = modelMapper.map(departmentDto, Department.class);

        Department department = departmentService.saveDepartment(departmentRequest);

        DepartmentDto departmentResponse = modelMapper.map(department, DepartmentDto.class);

        return ResponseEntity.ok().body(departmentResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> putDepartment(@PathVariable("id") Long departmentId,
                                                       @RequestBody DepartmentDto departmentDto) {
        Department departmentRequest = modelMapper.map(departmentDto, Department.class);

        Department department = departmentService.putDepartment(departmentId, departmentRequest);

        DepartmentDto departmentResponse = modelMapper.map(department, DepartmentDto.class);

        return ResponseEntity.ok().body(departmentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok().body("Delete successful");
    }


}
