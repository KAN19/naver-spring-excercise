package com.ronaldnguyen.naverweek1.controller;

import com.ronaldnguyen.naverweek1.model.Student;
import com.ronaldnguyen.naverweek1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public ModelAndView getStudents(Model model) {
        model.addAttribute("students", this.studentService.getStudentsOrderByAges());
        return new ModelAndView("students");
    }

    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable("id") Long ID) {
        return studentService.getStudentByID(ID);
    }

}
