package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools(){
        List<School>  activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByIsInActive")
    public List<School> getAllInActiveSchools(){
        List<School>  InactiveSchoolsList = schoolService.getAllInActiveSchools();
        return InactiveSchoolsList;
    }
    @RequestMapping(value = "getAllSchoolByLastRow")
    public List<School> getLatestRow(){
        List<School>  orderSchoolsList = schoolService.getLatestRow();
        return orderSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByLastUpdate")
    public List<School> getLatestUpdated() {
        List<School> lastUpdateSchoolsList = schoolService.getLatestUpdated();
        return lastUpdateSchoolsList;
    }

    @GetMapping(value = "deleteById")
    public String deleteSchoolById(@RequestParam Integer id) {

        schoolService.deleteSchoolById(id);
        return "Record Deleted Successfully :)";

    }





}
