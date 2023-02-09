package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneralController {
    @Autowired
    StudentService studentService;

    @Autowired
    SchoolService schoolService;

    //School Apis
    @RequestMapping(value="school/getAll",method= RequestMethod.GET)
    public List<School> getAllSchools(){
       // List<School> schools=new ArrayList<>();
        List<School> schools=schoolService.getAllSchools();
        return schools;
    }

//    @GetMapping(value = "addStudent")
//    public void studentFunction() {
//        studentService.addStudent();
//    }
//
//    @GetMapping(value = "hello")
//    public String hello() {
//        return "Hello Jamail";
//    }


}
