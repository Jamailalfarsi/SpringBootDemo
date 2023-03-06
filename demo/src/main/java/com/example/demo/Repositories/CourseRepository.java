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
public interface CourseRepository extends CrudRepository<Course,Integer> {

    @Query(value = "SELECT s from Course s")
    List<Course> getAllCourses();

    @Query (value = "SELECT s from Course s where s.id = :id")
    Course getCourseById(@Param("id")Integer id);

    @Query (value = "SELECT s from Course s where s.name= :name" )
    Course getByCourseName(@Param("name")String course_name);

    @Query(value = "SELECT s from Course s where s.isActive = true")
    List<Course> getAllActiveCourses();

    @Query(value = "SELECT s from Course s where s.isActive = false")
    List<Course> getAllInActiveCourses();

    @Query(value = "SELECT s from Course s where s.id=(SELECT max(id) from Course)")
    List<Course> getLatestRow();

    @Query(value = "SELECT s from Course s where s.cratedDate> :cratedDate")
    List<Course> getCourseCreatedAfterDate(@Param("cratedDate") Date cratedDate);

    @Query(value = "SELECT s from Course s where s.cratedDate= :cratedDate")
    Course getCourseByCreatedDate(@Param("cratedDate")String cratedDate);



}
