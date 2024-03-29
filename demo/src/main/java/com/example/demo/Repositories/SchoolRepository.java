package com.example.demo.Repositories;

import com.example.demo.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School,Integer> {

    @Query(value = "SELECT s from School s")
    List<School> getAllSchools();

    @Query (value = "SELECT s from School s where s.id = :id")
    School getSchoolById(@Param("id")Integer id);

    @Query (value = "SELECT s from School s where s.name= :name" )
    List<School> getBySchoolName(@Param("name")String school_name);

    @Query(value = "SELECT s from School s where s.isActive = true")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT s from School s where s.isActive = false")
    List<School> getAllInActiveSchools();

    @Query(value = "SELECT s from School s where s.id=(SELECT max(id) from School)")
    List<School> getLatestRow();

    @Query(value = "SELECT s from School s where s.updatedDate=(SELECT max(updatedDate) from School)")
    List<School> getLatestUpdated();
    @Query(value = "SELECT s from School s where s.createdDate> :createdDate")
    List<School> getSchoolCreatedAfterDate(@Param("createdDate")Date createdDate);

    @Query(value = "SELECT s from School s where s.createdDate= :createdDate")
    School getSchoolByCreatedDate(@Param("createdDate")Date cratedDate);
//    @Query (value = "DELETE s from School s where s.id = :id")
//    School deleteSchoolById(@Param("id")Integer id);

    @Query(value = "SELECT s from School s where s.updatedDate= :updatedDate")
    School getSchoolByUpdatedDate(@Param("updatedDate")Date updatedDate);










}
