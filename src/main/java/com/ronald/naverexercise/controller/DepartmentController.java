package com.ronald.naverexercise.controller;

import com.ronald.naverexercise.payload.BaseResponse;
import com.ronald.naverexercise.payload.dto.department.DepartmentDto;
import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.payload.dto.department.DepartmentWithNumEmpDto;
import com.ronald.naverexercise.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        return ResponseEntity.ok(BaseResponse.success(departments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable("id") Long id) {
        Department departmentById = departmentService.getDepartmentById(id);
        return ResponseEntity.ok().body(BaseResponse.success(departmentById));
    }

    @GetMapping("/with-num-employees/{id}")
    public ResponseEntity<?> getDepartmentByIdWithNumEmployees(@PathVariable("id") Long id) {
        DepartmentWithNumEmpDto departmentWithNumEmpDto = departmentService.getDepartmentWithNumEmployees(id);
        return ResponseEntity.ok().body(BaseResponse.success(departmentWithNumEmpDto));
    }

    @PostMapping
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        Department departmentRequest = modelMapper.map(departmentDto, Department.class);

        Department department = departmentService.saveDepartment(departmentRequest);

        DepartmentDto departmentResponse = modelMapper.map(department, DepartmentDto.class);

        return ResponseEntity.ok().body(BaseResponse.success(departmentResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putDepartment(@PathVariable("id") Long departmentId,
                                                       @RequestBody DepartmentDto departmentDto) {
        Department departmentRequest = modelMapper.map(departmentDto, Department.class);

        Department department = departmentService.putDepartment(departmentId, departmentRequest);

        DepartmentDto departmentResponse = modelMapper.map(department, DepartmentDto.class);

        return ResponseEntity.ok().body(BaseResponse.success(departmentResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok().body(BaseResponse.success(null, "Delete successful!"));
    }


}
