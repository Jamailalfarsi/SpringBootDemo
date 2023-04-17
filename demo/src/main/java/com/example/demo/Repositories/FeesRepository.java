package com.example.demo.Repositories;

import com.example.demo.Models.Fees;
import com.example.demo.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends CrudRepository<Fees,Integer> {



}
