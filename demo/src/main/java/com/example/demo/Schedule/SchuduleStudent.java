package com.example.demo.Schedule;

import com.example.demo.Models.Student;
import com.example.demo.Services.CourseService;
import com.example.demo.Services.StudentService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class SchuduleStudent {
    @Autowired
    SlackClient slackClient;
    @Autowired
    StudentService studentService;

    @Scheduled(cron= "0 /15 * * * *")
    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveSchools() {
        List<Student> activeStudentsList = studentService.getAllActiveStudents();
        for(Student s:activeStudentsList){
            slackClient.sendMessage("slackMessageActive:"+s.getActive().toString());
            slackClient.sendMessage("slackMessage_StudentId:"+s.getId().toString());
            slackClient.sendMessage("slackMessage_StudentName:"+s.getName().toString());
            slackClient.sendMessage("slackMassage_StudentCreatedDate"+s.getCreatedDate());
            slackClient.sendMessage("slackMassage_StudentUpdatedDate"+s.getUpdatedDate());
        }
        return activeStudentsList;
    }
}
