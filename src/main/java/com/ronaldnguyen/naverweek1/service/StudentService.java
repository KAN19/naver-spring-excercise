package com.ronaldnguyen.naverweek1.service;

import com.ronaldnguyen.naverweek1.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    Student getStudentByID(Long ID);
    List<Student> getStudentsOrderByAges();
}
