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

    @Autowired
    SchoolRepository schoolRepository;
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

    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolRepository.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;

    }

public List<Student> getAllActiveStudents() {

    return studentRepository.getAllActiveStudents();

}

    public List<Student> getAllInActiveStudents(){

        return studentRepository.getAllInActiveStudents();
    }

    public List<Student> getLatestRow(){

        return studentRepository.getLatestRow();
    }




}



