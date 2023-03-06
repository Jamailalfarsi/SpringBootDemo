package com.example.demo.controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getAllCourseByIsActive")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCoursesList = courseService.getAllActiveCourses();
        return activeCoursesList;
    }

    @RequestMapping(value = "getAllCourseByIsInActive")
    public List<Course> getAllInActiveCourses() {
        List<Course> InactiveCoursesList = courseService.getAllInActiveCourses();
        return InactiveCoursesList;
    }

    @RequestMapping(value = "getAllCoursesByLastRow")
    public List<Course> getLatestRow() {
        List<Course> orderCoursesList = courseService.getLatestRow();
        return orderCoursesList;
    }
//    @GetMapping(value = "deleteById")
//    public String deleteCourseById(@RequestParam Integer id) {
//
//        courseService.deleteCourseById(id);
//        return "Record Deleted Successfully :)";
//
//    }

    @RequestMapping(value = "deleteAll")
    public void deleteAll() {
        courseService.deleteAll();

    }

    @RequestMapping(value = "courseCreatedAfterDate")
    public List<Course> getCourseCreatedAfterDate(@RequestParam String cratedDate) throws ParseException {
        List<Course> courses = courseService.getCourseCreatedAfterDate(cratedDate);
        return courses;

    }
    @RequestMapping(value="getCourseByCreatedDate",method = RequestMethod.GET)
    public Course getCourseByCreatedDate(@RequestParam Date cratedDate){
        Course course=courseService.getCourseByCreatedDate(cratedDate);
        return course;
    }

    @RequestMapping(value="getSchoolByUpdatedDate",method = RequestMethod.GET)
    public Course getCourseByUpdatedDate(@RequestParam Date updatedDate){
        Course course=courseService.getCourseByUpdatedDate(updatedDate);
        return course;
    }
    @RequestMapping(value = "deleteCourseByCreatedDate", method = RequestMethod.POST)
    public void deleteCourseByCreatedDate(@RequestParam String cratedDate) throws ParseException {
        courseService.deleteCourseByCreatedDate(cratedDate);

    }
    @RequestMapping(value = "deleteCourseByUpdatedDate", method = RequestMethod.POST)
    public void deleteCourseByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        courseService.deleteCourseByUpdatedDate(updatedDate);

    }
}

