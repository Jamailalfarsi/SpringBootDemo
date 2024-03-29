package com.example.demo.controllers;

import ch.qos.logback.classic.Level;
import com.example.demo.Models.School;
import com.example.demo.RequestObject.SchoolRequestForCreateDataUpdate;
import com.example.demo.Services.ReportService;
import com.example.demo.Services.SchoolService;
import com.example.demo.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    SlackClient slackClient;
@Autowired
    ReportService reportService;

    @RequestMapping(value = "getAll")
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;
    }


    @RequestMapping(value = "getById")
    public School getSchoolById(@RequestParam Integer id) {
        School school = schoolService.getSchoolById(id);
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage("The school Id is:" + school.getId().toString());
        slackClient.sendMessage(school.getActive().toString());
        slackClient.sendMessage(school.getCreatedDate().toString());
        slackClient.sendMessage(school.getUpdatedDate().toString());


        return school;
    }

    @RequestMapping(value = "getByName")
    public List<School> getBySchoolName(@RequestParam String school_name) {
        List<School> school = schoolService.getBySchoolName(school_name);

        for(School s : school) {
            slackClient.sendMessage("The Name of the School is :" + s.getName());
            slackClient.sendMessage(s.getActive().toString());
            slackClient.sendMessage(s.getCreatedDate().toString());
            slackClient.sendMessage(s.getUpdatedDate().toString());
            slackClient.sendMessage(s.getCreatedDate().toString());
        }
        return school;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
         for(School s:activeSchoolsList){
//             slackClient.sendMessage("SlackMessage_SchoolInActive:"+s.getActive().toString());
//             slackClient.sendMessage("slackMessage_SchoolId:"+s.getId().toString());
//             slackClient.sendMessage("slackMessage_SchoolName:"+s.getName().toString());
//             slackClient.sendMessage("slackMassage_SchoolCreatedDate"+s.getCreatedDate());
//             slackClient.sendMessage("slackMassage_SchoolUpdatedDate"+s.getUpdatedDate());
             slackClient.sendMessage(schoolService.formatSchoolListForSlack(activeSchoolsList).toString());
         }
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByIsInActive")
    public List<School> getAllInActiveSchools() {
        List<School> InactiveSchoolsList = schoolService.getAllInActiveSchools();
        for(School s:InactiveSchoolsList){
//            slackClient.sendMessage("SlackMessage_SchoolInActive:"+s.getActive().toString());
//            slackClient.sendMessage("slackMessage_SchoolId:"+s.getId().toString());
//            slackClient.sendMessage("slackMessage_SchoolName:"+s.getName().toString());
//            slackClient.sendMessage("slackMassage_SchoolCreatedDate"+s.getCreatedDate());
//            slackClient.sendMessage("slackMassage_SchoolUpdatedDate"+s.getUpdatedDate());
            slackClient.sendMessage(schoolService.formatSchoolListForSlack(InactiveSchoolsList).toString());

        }

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

     //  schoolService.deleteBySchoolName(school_name);


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
        slackClient.sendMessage("SlackMessage_SchoolCreateDate:"+school.getCreatedDate().toString());

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

    @RequestMapping(value="report")
    public String generateSchoolReport()throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }
//    @RequestMapping(value="getStudentReport",method = RequestMethod.GET)
//    public void generateStudentReport() throws JRException, FileNotFoundException {
//        reportService.generateStudentReport();
//    }

    }
