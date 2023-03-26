package com.example.demo.Schedule;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Services.CourseService;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class ScheduleCourse {
    @Autowired
    SlackClient slackClient;
    @Autowired
    CourseService courseService;

    @Scheduled(cron= "0 /15 * * * *")

    @RequestMapping(value = "getAllCourseByIsActive")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCoursesList = courseService.getAllActiveCourses();
        for(Course s:activeCoursesList){
            slackClient.sendMessage("slackMessageActive:"+s.getActive().toString());
            slackClient.sendMessage("slackMessage_CourseId:"+s.getId().toString());
            slackClient.sendMessage("slackMessage_CourseName:"+s.getName().toString());
            slackClient.sendMessage("slackMassage_CourseCreatedDate"+s.getCreatedDate());
            slackClient.sendMessage("slackMassage_CourseUpdatedDate"+s.getUpdatedDate());
        }

        return activeCoursesList;
    }
    @RequestMapping(value = "getAllCourseByIsInActive")
    public List<Course> getAllInActiveCourses() {
        List<Course> InactiveCoursesList = courseService.getAllInActiveCourses();
        for(Course s:InactiveCoursesList) {
            slackClient.sendMessage("slackMessageInActive:" + s.getActive().toString());
            slackClient.sendMessage("slackMessage_CourseId:" + s.getId().toString());
            slackClient.sendMessage("slackMessage_CourseName:" + s.getName().toString());
            slackClient.sendMessage("slackMassage_CourseCreatedDate" + s.getCreatedDate());
            slackClient.sendMessage("slackMassage_CourseUpdatedDate" + s.getUpdatedDate());
        }
        return InactiveCoursesList;
    }



}