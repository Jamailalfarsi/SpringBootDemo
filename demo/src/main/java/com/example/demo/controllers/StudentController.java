package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveSchools(){
        List<Student>  activeStudentsList = studentService.getAllActiveStudents();
        return activeStudentsList;
    }
    @RequestMapping(value = "getAllStudentByIsInActive")
    public List<Student> getAllInActiveStudents(){
        List<Student>  InactiveStudentsList = studentService.getAllInActiveStudents();
        return InactiveStudentsList;
    }



}
