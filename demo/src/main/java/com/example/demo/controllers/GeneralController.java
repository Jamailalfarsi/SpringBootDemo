package com.example.demo.controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.MarkRepository;
import com.example.demo.Services.CourseService;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneralController {
    @Autowired
    StudentService studentService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    CourseService courseService;
    @Autowired
    MarkRepository markService;



    //School Apis
    @RequestMapping(value="school/getAll",method= RequestMethod.GET)
    public List<School> getAllSchools(){
       // List<School> schools=new ArrayList<>();
        List<School> schools=schoolService.getAllSchools();
        return schools;
    }

    @RequestMapping(value="student/getAll",method= RequestMethod.GET)
    public List<Student> getAllStudents(){
        // List<School> schools=new ArrayList<>();
        List<Student> students=studentService.getAllStudents();
        return students;
    }



    @RequestMapping(value="course/getAll",method= RequestMethod.GET)
    public List<Course> getAllCourses(){
        // List<School> schools=new ArrayList<>();

        List<Course> courses=courseService.getAllCourses();
        return courses;
    }

    @RequestMapping(value="mark/getAll",method= RequestMethod.GET)
    public List<Mark> getAllMarks(){
        // List<School> schools=new ArrayList<>();

        List<Mark> marks=markService.getAllMarks();
        return marks;
    }

    @RequestMapping(value="school/getById",method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer id){
        // School school=new School();
        School school=schoolService.getSchoolById(id);
        return school;
    }
    @RequestMapping(value="student/getById",method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id) {

        Student student = studentService.getStudentById(id);
        return student;
    }

    @RequestMapping(value="mark/getById",method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer id) {

        Mark mark = markService.getMarkById(id);
        return mark;
    }


    @RequestMapping(value="course/getById",method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer id){

        Course course=courseService.getCourseById(id);
        return course;
    }

}


