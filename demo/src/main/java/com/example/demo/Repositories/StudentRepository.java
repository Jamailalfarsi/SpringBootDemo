package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository


public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query(value = "SELECT s from Student s")
    List<Student> getAllStudents();

    @Query (value = "SELECT s from Student s where s.id = :id")
    Student getStudentById(@Param("id")Integer id);

    @Query (value = "SELECT s from Student s where s.name = :name")
    Student getByStudentName(@Param("name")String student_name);

    @Query(value = "SELECT st from Student st " +
            "WHERE st.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);

//    @Query (value = "SELECT s from Student s where s.id = :id")
//    Student deleteStudentById(@Param("id")Integer id);

    @Query(value = "SELECT s from Student s where s.isActive = true")
    List<Student> getAllActiveStudents();

    @Query(value = "SELECT s from Student s where s.isActive = false")
    List<Student> getAllInActiveStudents();

    @Query(value = "SELECT s from Student s where s.id=(SELECT max(id) from Student)")
    List<Student> getLatestRow();

    @Query(value = "SELECT s from Student s where s.cratedDate> :cratedDate")
    List<Student> getStudentCreatedAfterDate(@Param("cratedDate") Date cratedDate);

    @Query(value = "SELECT s from Student s where s.cratedDate= :cratedDate")
    Student getStudentByCreatedDate(@Param("cratedDate")Date cratedDate);

    @Query(value = "SELECT s from Student s where s.updatedDate= :updatedDate")
    Student getStudentByUpdatedDate(@Param("updatedDate")Date updatedDate);

    @Query (value = "SELECT s from Student s where s.age = :age")
    Student getStudentByAge(@Param("age")Integer age);



}
