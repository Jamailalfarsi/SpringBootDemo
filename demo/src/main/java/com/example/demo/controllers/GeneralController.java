package com.example.demo.controllers;

import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "addStudent")
    public void studentFunction() {
        studentService.addStudent();
    }

    @GetMapping(value = "hello")
    public String hello() {
        return "Hello Jamail";
    }


}
