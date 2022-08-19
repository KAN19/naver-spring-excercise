package com.ronaldnguyen.naverweek1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Student {

    private Long ID;
    private String name;
    private Integer age;
    private String hobbies;

}
