package com.ronald.naverexercise.controller;

import com.ronald.naverexercise.factory.ComputerFactory;
import com.ronald.naverexercise.factory.computer.product.Computer;
import com.ronald.naverexercise.payload.BaseResponse;
import com.ronald.naverexercise.payload.dto.employee.EmployeeWithDepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factory-method")
public class FactoryMethodController {

    @Autowired
    private ComputerFactory computerFactory;

    @GetMapping("/{type}")
    public ResponseEntity<?> getComputerType(@PathVariable("type") String type) {
        Computer computer = computerFactory.getComputer(type);
        System.out.println("Type: " + type);
        System.out.println("Computer: " + computer.getType());
        return ResponseEntity.ok().body(BaseResponse.success(computer));
    }

}
