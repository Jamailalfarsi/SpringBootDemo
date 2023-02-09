package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer> {
}
