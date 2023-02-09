package com.example.demo.Repositories;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School,Integer> {
}
