package com.example.demo.controllers;

import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    StudentService studentService;
}
