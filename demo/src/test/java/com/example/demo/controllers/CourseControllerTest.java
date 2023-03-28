package com.example.demo.controllers;

import com.example.demo.Models.Course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CourseControllerTest {
    @Autowired
    CourseController courseController;

    @Test
    void getAllCourses() {
    }

    @Test
    void getCourseById() throws  Exception{
            String courseName=courseController.getCourseById(2).getName();
            assertEquals("English",courseName);
    }
    @Test
    void getCourseById1() throws  Exception{
        String courseName=courseController.getCourseById(3).getName();
        assertEquals("English",courseName);
    }
    @Test
    void getCourseById2() throws  Exception{
        String courseName=courseController.getCourseById(4).getName();
        assertEquals("English",courseName);
    }
    @Test
    void getCourseByIdWhenIdZerro()throws  Exception{
        Course courseToTest=courseController.getCourseById(0);
        assertEquals(null,courseToTest);

    }



    @Test
    void getByCourseName() {

    }

    @Test
    void getAllActiveCourses() {
//        List<Course> Course=courseController.getByCourseName("English");
//        for(Course cr:Course){
//            assertEquals(2,cr.getId());
//        }

    }

    @Test
    void getAllInActiveCourses() {
//        List<Course> Course=courseController.getByCourseName("English");
//        for(Course cr:Course){
//            assertEquals(4,cr.getId());
//        }
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void deleteCourseById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void getCourseCreatedAfterDate() {
    }

    @Test
    void getCourseByCreatedDate() {
//        Course courseToTest;
//        courseToTest = courseController.getCourseByCreatedDate(valueOf("2022-01-01"));
//        String courseName=courseToTest.getName();
//        assertEquals("English",courseName);
    }

    @Test
    void getCourseByUpdatedDate() {
    }

    @Test
    void deleteCourseByCreatedDate() {

    }

    @Test
    void deleteCourseByUpdatedDate() {
    }

    @Test
    void createCourse() {
    }
}