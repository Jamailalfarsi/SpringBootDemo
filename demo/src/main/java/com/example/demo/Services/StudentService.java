package com.example.demo.Services;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class StudentService {

    @Autowired
    StudentRepository StudentRepository;
    public void addStudent(){
        Student student=new Student();
        student.setName("Muzzamil Arif");
        student.setAge(20);

        StudentRepository.save(student);



    }
}
