package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query(value = "SELECT s from Student s")
    List<Student> getAllStudents();
}
