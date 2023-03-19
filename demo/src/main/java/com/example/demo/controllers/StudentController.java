package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.StudentService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getAll")
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students = studentService.getAllStudents();

        for(Student s : students) {
            slackClient.sendMessage("The Name of the Student is :" + s.getName().toString());
            slackClient.sendMessage(s.getActive().toString());
            slackClient.sendMessage(s.getCreatedDate().toString());
            slackClient.sendMessage(s.getUpdatedDate().toString());
            slackClient.sendMessage(s.getCreatedDate().toString());
        }

        return students;
    }


    @RequestMapping(value = "getById")
    public Student getStudentById(@RequestParam Integer id) {
        Student student = studentService.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "getByName")
    public Student getByStudentName(@RequestParam String student_name) {
        Student student = studentService.getByStudentName(student_name);
        return student;
    }


    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveSchools() {
        List<Student> activeStudentsList = studentService.getAllActiveStudents();
        for(Student s:activeStudentsList){
            slackClient.sendMessage("slackMessageActive:"+s.getActive().toString());
        }
        return activeStudentsList;
    }

    @RequestMapping(value = "getAllStudentByIsInActive")
    public List<Student> getAllInActiveStudents() {
        List<Student> InactiveStudentsList = studentService.getAllInActiveStudents();
        for(Student s:InactiveStudentsList){
            slackClient.sendMessage("slackMessageInActive:"+s.getActive().toString());
            slackClient.sendMessage("slackMessage_StudentId:"+s.getId().toString());
            slackClient.sendMessage("slackMessage_StudentName:"+s.getName().toString());
            slackClient.sendMessage("slackMassage_StudentCreatedDate"+s.getCreatedDate());
            slackClient.sendMessage("slackMassage_StudentUpdatedDate"+s.getUpdatedDate());
        }
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
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Student> students = studentService.getStudentCreatedAfterDate(createdDate);
        return students;


    }

    @RequestMapping(value="getStudentByCreatedDate",method = RequestMethod.GET)
    public Student getStudentByCreatedDate(@RequestParam Date createdDate){
        Student student=studentService.getStudentByCreatedDate(createdDate);
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
    public void deleteStudentsByCreatedDate(@RequestParam String createdDate) throws ParseException {
        studentService.deleteStudentByCreatedDate(createdDate);

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
