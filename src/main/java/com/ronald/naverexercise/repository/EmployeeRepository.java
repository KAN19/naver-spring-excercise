package com.ronald.naverexercise.repository;

import com.ronald.naverexercise.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmployeeId(Long employeeId);
}
