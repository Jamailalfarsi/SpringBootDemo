package com.example.demo.Schedule;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class Schedule {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;

    @Autowired
    StudentService studentService;

    @Scheduled(cron= "0 */5 * * * *")
    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        for(School s:activeSchoolsList){
            slackClient.sendMessage("SlackMessage_SchoolInActive:"+s.getActive().toString());
            slackClient.sendMessage("slackMessage_SchoolId:"+s.getId().toString());
            slackClient.sendMessage("slackMessage_SchoolName:"+s.getName().toString());
            slackClient.sendMessage("slackMassage_SchoolCreatedDate"+s.getCreatedDate());
            slackClient.sendMessage("slackMassage_SchoolUpdatedDate"+s.getUpdatedDate());

        }
        return activeSchoolsList;
    }
    @RequestMapping(value = "getAllSchoolByIsInActive")
    public List<School> getAllInActiveSchools() {
        List<School> InactiveSchoolsList = schoolService.getAllInActiveSchools();
        for(School s:InactiveSchoolsList){
            slackClient.sendMessage("SlackMessage_SchoolInActive:"+s.getActive().toString());
            slackClient.sendMessage("slackMessage_SchoolId:"+s.getId().toString());
            slackClient.sendMessage("slackMessage_SchoolName:"+s.getName().toString());
            slackClient.sendMessage("slackMassage_SchoolCreatedDate"+s.getCreatedDate());
            slackClient.sendMessage("slackMassage_SchoolUpdatedDate"+s.getUpdatedDate());


        }

        return InactiveSchoolsList;
    }

}
