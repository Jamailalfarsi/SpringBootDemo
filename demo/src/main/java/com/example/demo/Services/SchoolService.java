package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools(){
        return schoolRepository.getAllSchools();
    }
    public  School getSchoolById(Integer id){
        School school = new School();
        return school;
    }
}
