package com.example.demo.controllers;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Services.MarkService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @Autowired
    SlackClient slackClient;


    public List<Mark> getAllMarks() {
        return markService.getAllMarks();
    }

    public Mark getMarkById(Integer id) {
        return markService.getMarkById(id);

    }

    @RequestMapping(value = "getAllMarkByIsInActive")
    public List<Mark> getAllInActiveMarks() {
        List<Mark> InactiveMarksList = markService.getAllInActiveMarks();
        for(Mark s:InactiveMarksList){
            slackClient.sendMessage("SlackMessage_MarkInActive:"+s.getActive().toString());
            slackClient.sendMessage("slackMessage_MarkId:"+s.getId().toString());
            slackClient.sendMessage("slackMessage_MarkObtain:"+s.getObtainMark().toString());
            slackClient.sendMessage("slackMassage_MarkCreatedDate:"+s.getCreatedDate());
            slackClient.sendMessage("slackMassage_MArkUpdatedDate:"+s.getUpdatedDate());
            slackClient.sendMessage("slackMassage_MArkGrade:"+s.getGrade());




        }

        return InactiveMarksList;
    }

    @RequestMapping(value = "getAllMarkByIsActive")
    public List<Mark> getAllActiveMarks() {
        List<Mark> ActiveMarksList = markService.getAllActiveMarks();
        for(Mark s:ActiveMarksList){
            slackClient.sendMessage("SlackMessage_MarkInActive:"+s.getActive().toString());
            slackClient.sendMessage("slackMessage_MarkId:"+s.getId().toString());
            slackClient.sendMessage("slackMessage_MarkObtain:"+s.getObtainMark().toString());
            slackClient.sendMessage("slackMassage_MarkCreatedDate:"+s.getCreatedDate());
            slackClient.sendMessage("slackMassage_MArkUpdatedDate:"+s.getUpdatedDate());
            slackClient.sendMessage("slackMassage_MArkGrade:"+s.getGrade());


        }

        return ActiveMarksList;
    }


    @RequestMapping(value = "getAllMarkByLastRow")
    public List<Mark> getLatestRow() {
        List<Mark> orderMarksList = markService.getLatestRow();
        return orderMarksList;
    }
//    @GetMapping(value = "deleteById")
//    public String deleteMarkById(@RequestParam Integer id) {
//
//        markService.deleteMarkById(id);
//        return "Record Deleted Successfully :)";
//
//    }

    @RequestMapping(value = "deleteById")
    public void deleteMarkById(@RequestParam Integer id) {

        markService.deleteMarkById(id);

    }

    @RequestMapping(value = "deleteAll")
    public void deleteAll() {
        markService.deleteAll();

    }

    @RequestMapping(value = "markCreatedAfterDate")
    public List<Mark> getMarkCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Mark> marks = markService.getMarkCreatedAfterDate(createdDate);
        return marks;
    }
    @RequestMapping(value="getMarkByCreatedDate",method = RequestMethod.GET)
    public Mark getMarkByCreatedDate(@RequestParam Date createdDate){
        Mark mark=markService.getMarkByCreatedDate(createdDate);
        return mark;
    }

    @RequestMapping(value="getSchoolByUpdatedDate",method = RequestMethod.GET)
    public Mark getMarkByUpdatedDate(@RequestParam Date updatedDate){
        Mark mark=markService.getMarkByUpdatedDate(updatedDate);
        return mark;
    }
    @RequestMapping(value = "deleteMarkByCreatedDate", method = RequestMethod.POST)
    public void deleteMarkByCreatedDate(@RequestParam String createdDate) throws ParseException {
        markService.deleteMarkByCreatedDate(createdDate);

    }
    @RequestMapping(value = "deleteMarkByUpdatedDate", method = RequestMethod.POST)
    public void deleteMarkByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        markService.deleteMarkByUpdatedDate(updatedDate);

    }
    @RequestMapping(value = "createMark", method = RequestMethod.POST)
    public void createMark(@RequestParam String grade,Integer obtainMark) {
        markService.createMark(grade,obtainMark);
    }
    @RequestMapping(value = "updateMark",method = RequestMethod.POST)
    public void updateMark(@RequestParam Integer id,String grade,Integer obtainMark,Boolean  isActive){
        markService.updateMark(id, grade,obtainMark, isActive);
    }

}