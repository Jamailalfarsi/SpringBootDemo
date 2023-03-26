package com.example.demo.Schedule;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Services.CourseService;
import com.example.demo.Services.MarkService;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class ScheduleMark {
    @Autowired
    SlackClient slackClient;
    @Autowired
    MarkService markService;

    @Scheduled(cron= "0 /15 * * * *")

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



}

