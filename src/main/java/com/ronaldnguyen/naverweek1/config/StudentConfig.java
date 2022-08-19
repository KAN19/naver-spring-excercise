package com.ronaldnguyen.naverweek1.config;

import com.ronaldnguyen.naverweek1.model.Student;
import com.ronaldnguyen.naverweek1.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository) {
        return args -> {
            Student student1 = new Student(0L, "Tommy", 10, "swimming");
            Student student2 = new Student(1L, "Kate", 18, "Playing the guitar");
            Student student3 = new Student(2L, "John", 13, "Reading");
            Student student4 = new Student(3L, "Ronald", 17, "Chatting");
            Student student5 = new Student(4L, "John", 13, "Video games");

            studentRepository.initTestStudents(List.of(student1, student2, student3, student4, student5));
        };
    }
}
