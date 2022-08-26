package com.ronald.naverexercise.service.impl;

import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.error.NotFoundException;
import com.ronald.naverexercise.repository.DepartmentRepository;
import com.ronald.naverexercise.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findDepartmentByDepartmentId(departmentId);
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department putDepartment(Long id, Department departmentRequest) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay " + id));

        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay " + id));
        departmentRepository.delete(department);
    }
}
