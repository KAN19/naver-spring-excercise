package com.ronaldnguyen.naverweek1.repository;

import com.ronaldnguyen.naverweek1.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    Student getStudentByID(Long ID);
    List<Student> getStudents();
    void initTestStudents(List<Student> students);
}
