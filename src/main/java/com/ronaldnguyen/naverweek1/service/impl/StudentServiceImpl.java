package com.ronaldnguyen.naverweek1.service.impl;

import com.ronaldnguyen.naverweek1.model.Student;
import com.ronaldnguyen.naverweek1.repository.StudentRepository;
import com.ronaldnguyen.naverweek1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentByID(Long ID) {
        return studentRepository.getStudentByID(ID);
    }

    @Override
    public List<Student> getStudentsOrderByAges() {
        return studentRepository.getStudents().stream().sorted(
                Comparator.comparing(Student::getAge).reversed()
        ).collect(Collectors.toList());
    }
}
