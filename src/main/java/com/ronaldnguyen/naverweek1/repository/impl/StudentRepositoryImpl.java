package com.ronaldnguyen.naverweek1.repository.impl;

import com.ronaldnguyen.naverweek1.model.Student;
import com.ronaldnguyen.naverweek1.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> studentList;

    @Override
    public Student getStudentByID(Long ID) {
        return studentList.stream()
                .filter(student -> ID.equals(student.getID()))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Student> getStudents() {
        return studentList;
    }

    @Override
    public void initTestStudents(List<Student> students) {
        this.studentList = students;
    }
}
