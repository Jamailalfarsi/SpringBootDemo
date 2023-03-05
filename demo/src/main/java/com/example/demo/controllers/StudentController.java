package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveSchools() {
        List<Student> activeStudentsList = studentService.getAllActiveStudents();
        return activeStudentsList;
    }

    @RequestMapping(value = "getAllStudentByIsInActive")
    public List<Student> getAllInActiveStudents() {
        List<Student> InactiveStudentsList = studentService.getAllInActiveStudents();
        return InactiveStudentsList;
    }

    @RequestMapping(value = "getAllStudentByLastRow")
    public List<Student> getLatestRow() {
        List<Student> orderStudentsList = studentService.getLatestRow();
        return orderStudentsList;
    }

    @GetMapping(value = "deleteById")
    public void deleteStudentById(@RequestParam Integer id) {

        studentService.deleteStudentById(id);

    }

    @GetMapping(value = "deleteByStudentName")
    public void deleteByStudentName(@RequestParam String student_name) {

        studentService.deleteByStudentName(student_name);

    }

    @GetMapping(value = "deleteAll")
    public void deleteAll() {
        studentService.deleteAll();

    }

    @GetMapping(value = "studentCreatedAfterDate")
    public List<Student> getStudentCreatedAfterDate(@RequestParam String cratedDate) throws ParseException {
        List<Student> students = studentService.getStudentCreatedAfterDate(cratedDate);
        return students;


    }
}
