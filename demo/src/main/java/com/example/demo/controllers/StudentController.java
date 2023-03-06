package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
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

    @RequestMapping(value="getStudentByCreatedDate",method = RequestMethod.GET)
    public Student getStudentByCreatedDate(@RequestParam Date cratedDate){
        Student student=studentService.getStudentByCreatedDate(cratedDate);
        return student;
    }

    @RequestMapping(value="getStudentByUpdatedDate",method = RequestMethod.GET)
    public Student getStudentByUpdatedDate(@RequestParam Date updatedDate){
        Student student=studentService.getStudentByUpdatedDate(updatedDate);
        return student;
    }
    @RequestMapping(value="getStudentByAge",method = RequestMethod.GET)
    public Student getStudentByAge(@RequestParam Integer age){
        Student student=studentService.getStudentByAge(age);
        return student;
    }
    @RequestMapping(value = "deleteStudentsByCreatedDate", method = RequestMethod.POST)
    public void deleteStudentsByCreatedDate(@RequestParam String cratedDate) throws ParseException {
        studentService.deleteStudentByCreatedDate(cratedDate);

    }
}
