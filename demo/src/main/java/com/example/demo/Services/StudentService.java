package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

//    public void deleteStudentById(Integer id){
//        Student studentToDelete = studentRepository.findById(id).get();
//        studentRepository.delete(studentToDelete);
//    }

    public void deleteStudentById(Integer id){
        Student student = studentRepository.getStudentById(id);
        student.setActive(false);
        studentRepository.save(student);
    }

    public void deleteByStudentName(String student_name){
        Student student = studentRepository. getByStudentName(student_name);
        student.setActive(false);
        studentRepository.save(student);
    }

    public void deleteAll(){
        Iterable<Student> students= studentRepository.findAll();
        for(Student student:students) {
            student.setActive(false);
        }
        studentRepository.saveAll(students);
    }

    public List<Student> getStudentCreatedAfterDate(String cratedDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(cratedDate);
        List<Student> students = studentRepository.getStudentCreatedAfterDate(javaDate);
        return students;
    }


    public Student getStudentByCreatedDate(Date cratedDate) {

        return studentRepository.getStudentByCreatedDate(cratedDate);
    }
    public Student getStudentByUpdatedDate(Date updatedDate) {

        return studentRepository.getStudentByUpdatedDate(updatedDate);
    }
    public Student getStudentByAge(Integer age) {

        return studentRepository.getStudentByAge(age);
    }

    public void deleteStudentByCreatedDate(String cratedDate) throws ParseException{
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(cratedDate);
        Student student = studentRepository.getStudentByCreatedDate(javaDate);
        student.setActive(false);
        studentRepository.save(student);
    }








}



