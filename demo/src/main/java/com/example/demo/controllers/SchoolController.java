package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.RequestObject.SchoolRequestForCreateDataUpdate;
import com.example.demo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByIsInActive")
    public List<School> getAllInActiveSchools() {
        List<School> InactiveSchoolsList = schoolService.getAllInActiveSchools();
        return InactiveSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByLastRow")
    public List<School> getLatestRow() {
        List<School> orderSchoolsList = schoolService.getLatestRow();
        return orderSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByLastUpdate")
    public List<School> getLatestUpdated() {
        List<School> lastUpdateSchoolsList = schoolService.getLatestUpdated();
        return lastUpdateSchoolsList;
    }

//    @GetMapping(value = "deleteById")
//    public String deleteSchoolById(@RequestParam Integer id) {
//
//        schoolService.deleteSchoolById(id);
//        return "Record Deleted Successfully :)";
//
//    }

    @RequestMapping(value = "updateCreateDateByUserInput")
    public void setCreateDateByUserInput(@RequestBody SchoolRequestForCreateDataUpdate data) throws ParseException {

        schoolService.setCreateDateByUserInput(data.getDate(), data.getId());
    }

    @RequestMapping(value = "deleteById")
    public void deleteSchoolById(@RequestParam Integer id) {

        schoolService.deleteSchoolById(id);
       // return "Record Deleted Successfully :)";

    }
    @RequestMapping(value = "deleteBySchoolName")
    public void deleteBySchoolName(@RequestParam String school_name) {

        schoolService.deleteBySchoolName(school_name);


    }
    @RequestMapping(value = "deleteAll")
    public void deleteAll() {
        schoolService.deleteAll();

    }

    @RequestMapping(value="schoolCreatedAfterDate")
    public List <School> getSchoolCreatedAfterDate (@RequestParam String createdDate) throws ParseException {
        List <School> schools= schoolService.getSchoolCreatedAfterDate(createdDate);
       return schools;
    }

    @RequestMapping(value="getSchoolByCreatedDate",method = RequestMethod.GET)
    public School getSchoolByCreatedDate(@RequestParam Date createdDate){
        School school=schoolService.getSchoolByCreatedDate(createdDate);
        return school;
    }

    @RequestMapping(value="getSchoolByUpdatedDate",method = RequestMethod.GET)
    public School getSchoolByUpdatedDate(@RequestParam Date updatedDate){
        School school=schoolService.getSchoolByUpdatedDate(updatedDate);
        return school;
    }
    @RequestMapping(value = "deleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public void deleteSchoolsByCreatedDate(@RequestParam String createdDate) throws ParseException {
       schoolService.deleteSchoolsByCreatedDate(createdDate);

    }
    @RequestMapping(value = "deleteSchoolsByUpdatedDate", method = RequestMethod.POST)
    public void deleteSchoolsByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        schoolService.deleteSchoolsByUpdatedDate(updatedDate);

    }
    @RequestMapping(value = "createSchool", method = RequestMethod.POST)
    public void createSchool(@RequestParam String school_name) {
        schoolService.createSchool(school_name);
    }

    @RequestMapping(value = "updateSchool",method = RequestMethod.POST)
    public void updateSchool(@RequestParam Integer id,String school_name,Boolean  isActive){
        schoolService.updateSchool(id, school_name, isActive);
    }










}
