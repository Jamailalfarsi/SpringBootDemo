package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface MarkRepository extends JpaRepository<Mark,Integer> {
    @Query(value = "SELECT s from Mark s")
    List<Mark> getAllMarks();

    @Query (value = "SELECT s from Mark s where s.id = :id")
    Mark getMarkById(@Param("id")Integer id);

    @Query(value = "SELECT s from Mark s where s.isActive = true")
    List<Mark> getAllActiveMarks();
    @Query(value = "SELECT s from Mark s where s.isActive = false")
    List<Mark> getAllInActiveMarks();
    @Query(value = "SELECT s from Mark s where s.id=(SELECT max(id) from Mark)")
    List<Mark> getLatestRow();

    @Query(value = "SELECT s from Mark s where s.createdDate> :createdDate")
    List<Mark> getMarkCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "SELECT s from Mark s where s.createdDate= :createdDate")
    Mark getMarkByCreatedDate(@Param("createdDate")Date createdDate);

    @Query(value = "SELECT s from Mark s where s.updatedDate= :updatedDate")
    Mark getMarkByUpdatedDate(@Param("updatedDate")Date updatedDate);

    @Query(value = "select m from Mark m where m.course.name = :courseName ")
    List<Mark> getMarksByCourseName(@Param("courseName") String courseName);

    @Query(value = "select AVG(m.obtainMark) from Mark m where m.course.name = :courseName ")
    Integer getAverageOfMarksByCourseName(@Param("courseName") String courseName);
    @Query(value = "select sum(m.obtainMark) from Mark m where m.course.student.id  = :studentId ")
    Integer getSumOfMarksByStudentId(@Param("studentId") Integer studentId);



}

