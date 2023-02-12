package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
//    public void addStudent(){
//        Student student=new Student();
//        student.setName("Muzzamil Arif");
//        student.setAge(20);
//
//        StudentRepository.save(student);

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public  Student getStudentById(Integer id){
        return  studentRepository.getStudentById(id);

    }
    public Student getByStudentName(String student_name){
        return studentRepository.getByStudentName(student_name);
    }

    }



