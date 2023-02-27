package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service

public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools(){
        return schoolRepository.getAllSchools();
    }
    public  School getSchoolById(Integer id){
        return  schoolRepository.getSchoolById(id);

    }
    public School getBySchoolName( String school_name){

        return schoolRepository.getBySchoolName(school_name);
    }

    public List<School> getAllActiveSchools(){

        return schoolRepository.getAllActiveSchools();
    }

    public List<School> getAllInActiveSchools(){

        return schoolRepository.getAllInActiveSchools();
    }

    public List<School> getLatestRow(){

        return schoolRepository.getLatestRow();
    }

    public List<School> getLatestUpdated(){

        return schoolRepository.getLatestUpdated();
    }

    public void deleteSchoolById(Integer id){
        School schoolToDelete = schoolRepository.findById(id).get();
        schoolRepository.delete(schoolToDelete);
    }
public void setCreateDateByUserInput(String stringDate,Integer id )throws ParseException{
    DateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
    Date javaDate =formatter.parse(stringDate);
    School school =schoolRepository.getSchoolById(id);
    schoolRepository.save(school);
}






}
