package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentController studentController;
    @Test
    void getAllStudents() {
    }

    @Test
    void getStudentById() throws  Exception {
            String studentName=studentController.getStudentById(2).getName();
            assertEquals("Maha",studentName);
    }
    @Test
    void getStudentById1() throws  Exception {
        String studentName=studentController.getStudentById(3).getName();
        assertEquals("sara",studentName);
    }
    @Test
    void getStudentById2() throws  Exception {
        String studentName=studentController.getStudentById(4).getName();
        assertEquals("sara",studentName);
    }
    @Test
    void getStudentByIdWhenIdZerro()throws  Exception{
        Student studentToTest=studentController.getStudentById(0);
        assertEquals(null,studentToTest);

    }

    @Test
    void getByStudentName() {
    }

    @Test
    void getAllActiveSchools() {
    }

    @Test
    void getAllInActiveStudents() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void deleteStudentById() {
    }

    @Test
    void deleteByStudentName() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void getStudentCreatedAfterDate() {
    }

    @Test
    void getStudentByCreatedDate() {
    }

    @Test
    void getStudentByUpdatedDate() {
    }

    @Test
    void getStudentByAge() {
    }

    @Test
    void deleteStudentsByCreatedDate() {
    }

    @Test
    void deleteStudentByUpdatedDate() {
    }

    @Test
    void createStudent() {
    }

    @Test
    void updateStudent() {
    }
}