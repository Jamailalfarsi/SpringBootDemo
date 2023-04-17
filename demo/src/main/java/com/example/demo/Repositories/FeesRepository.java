package com.example.demo.Repositories;

import com.example.demo.Models.Fees;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FeesRepository extends CrudRepository<Fees,Integer> {

    @Query(value = "SELECT s from Fees s")
    List<Fees> getAllFeeses();

    @Query (value = "SELECT s from Fees s where s.id = :id")
    Fees getFeesById(@Param("id")Integer id);

    @Query(value = "SELECT s from Fees s where s.datePaid= :datePaid")
    Fees getFeesBydatePaid(@Param("datePaid") Date datePaid);

}
