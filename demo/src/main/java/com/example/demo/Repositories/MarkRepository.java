package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark,Integer> {
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



}
