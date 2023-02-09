package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<Mark,Integer> {
}
