package com.ronald.naverexercise.config;

import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SampleDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository departmentRepository) {
        List<Department> departments = List.of(
                new Department(1L, "department 1", "Hello", null),
                new Department(2L, "department 2", "Hello", null),
                new Department(3L, "department 3", "Hello", null)
                );

        return args -> {
            departmentRepository.saveAll(departments);
        };
    }

}
