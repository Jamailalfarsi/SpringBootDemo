package com.example.demo.controllers;

import com.example.demo.Models.School;
import com.example.demo.RequestObject.SchoolRequestForCreateDataUpdate;
import com.example.demo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @GetMapping(value = "deleteById")
    public String deleteSchoolById(@RequestParam Integer id) {

        schoolService.deleteSchoolById(id);
        return "Record Deleted Successfully :)";

    }

    @RequestMapping(value = "updateCreateDateByUserInput", method = RequestMethod.POST)
    public void setCreateDateByUserInput(@RequestBody SchoolRequestForCreateDataUpdate data) throws ParseException {

        schoolService.setCreateDateByUserInput(data.getDate(), data.getId());
    }


}
