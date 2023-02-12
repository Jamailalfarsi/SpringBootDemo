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
    CourseService CourseService;
    @Autowired
    MarkRepository markService;



    //School Apis
    @RequestMapping(value="school/getAll",method= RequestMethod.GET)
    public List<School> getAllSchools(){
       // List<School> schools=new ArrayList<>();
        List<School> schools=schoolService.getAllSchools();
        return schools;
    }

    @RequestMapping(value="school/getById",method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer id){
       // School school=new School();
        School school=schoolService.getSchoolById(id);
        return school;
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

        List<Course> courses=CourseService.getAllCourses();
        return courses;
    }

    @RequestMapping(value="mark/getAll",method= RequestMethod.GET)
    public List<Mark> getAllMarks(){
        // List<School> schools=new ArrayList<>();

        List<Mark> marks=markService.getAllMarks();
        return marks;
    }

//    @GetMapping(value = "addStudent")
//    public void studentFunction() {
//        studentService.addStudent();
//    }
//
//    @GetMapping(value = "hello")
//    public String hello() {
//        return "Hello Jamail";
//    }


}
