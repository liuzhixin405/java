package com.example.bootlanuch.controller;

import com.example.bootlanuch.model.Student;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        Student student = Student.builder().name(name).age(20).build();

        return "hello my world ----"+name;
    }
}
