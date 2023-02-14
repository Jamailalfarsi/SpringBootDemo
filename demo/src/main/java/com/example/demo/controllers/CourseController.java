package com.example.demo.controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getAllCourseByIsActive")
    public List<Course> getAllActiveCourses(){
        List<Course>  activeCoursesList = courseService.getAllActiveCourses();
        return activeCoursesList;
    }
    @RequestMapping(value = "getAllCourseByIsInActive")
    public List<Course> getAllInActiveCourses(){
        List<Course>  InactiveCoursesList = courseService.getAllInActiveCourses();
        return InactiveCoursesList;
    }

    @RequestMapping(value = "getAllCoursesByLastRow")
    public List<Course> getLatestRow() {
        List<Course> orderCoursesList = courseService.getLatestRow();
        return orderCoursesList;
    }
}
