package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(Integer id){
        return courseRepository.getCourseById(id);
    }

    public Course getByCourseName( String course_name){
        return courseRepository.getByCourseName(course_name);


    }
    public List<Course> getAllActiveCourses(){

        return courseRepository.getAllActiveCourses();
    }

    public List<Course> getAllInActiveCourses(){

        return courseRepository.getAllInActiveCourses();
    }

    public List<Course> getLatestRow(){

        return courseRepository.getLatestRow();
    }





}
