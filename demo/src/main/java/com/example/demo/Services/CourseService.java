package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

//    public void deleteCourseById(Integer id){
//        Course courseToDelete = courseRepository.findById(id).get();
//        courseRepository.delete(courseToDelete);
//    }

    public void deleteCourselById(Integer id){
        Course course = courseRepository.getCourseById(id);
        course.setActive(false);
        courseRepository.save(course);
    }

    public void deleteByCourseName(String course_name){
        Course course = courseRepository. getByCourseName(course_name);
        course.setActive(false);
        courseRepository.save(course);
    }

    public void deleteAll(){
        Iterable<Course> courses= courseRepository.findAll();
        for(Course course:courses) {
            course.setActive(false);
        }
        courseRepository.saveAll(courses);

    }

    public List<Course> getCourseCreatedAfterDate(String cratedDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(cratedDate);
        List<Course> courses = courseRepository.getCourseCreatedAfterDate(javaDate);
        return courses;
    }
    public Course getCourseByCreatedDate(Date cratedDate) {
        return courseRepository.getCourseByCreatedDate(cratedDate);
    }
    public Course getCourseByUpdatedDate(Date updatedDate) {
        return courseRepository.getCourseByUpdatedDate(updatedDate);
    }
    public void deleteCourseByCreatedDate(String cratedDate) throws ParseException{
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(cratedDate);
        Course course= courseRepository.getCourseByCreatedDate(javaDate);
        course.setActive(false);
        courseRepository.save(course);
    }
    public void deleteCourseByUpdatedDate(String updatedDate) throws ParseException{
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(updatedDate);
        Course course = courseRepository.getCourseByUpdatedDate(javaDate);
        course.setActive(false);
        courseRepository.save(course);
    }








}
