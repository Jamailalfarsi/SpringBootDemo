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

    @RequestMapping(value = "deleteById")
    public void deleteStudentById(@RequestParam Integer id) {

        studentService.deleteStudentById(id);

    }

    @RequestMapping(value = "deleteByStudentName")
    public void deleteByStudentName(@RequestParam String student_name) {

        studentService.deleteByStudentName(student_name);

    }

    @RequestMapping(value = "deleteAll")
    public void deleteAll() {
        studentService.deleteAll();

    }

    @RequestMapping(value = "studentCreatedAfterDate")
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
    @RequestMapping(value = "deleteStudentsByUpdatedDate", method = RequestMethod.POST)
    public void deleteStudentByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        studentService.deleteStudentByUpdatedDate(updatedDate);

    }
    @RequestMapping(value = "createStudent", method = RequestMethod.POST)
    public void createStudent(@RequestParam String student_name) {
        studentService.createStudent(student_name);

    }
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST)
    public void updateStudent(@RequestParam Integer id,String student_name,Boolean  isActive){
        studentService.updateStudent(id, student_name, isActive);
    }
}
