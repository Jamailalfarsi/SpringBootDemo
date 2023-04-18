package com.example.demo.controllers;

import com.example.demo.Services.ReportService;
import com.example.demo.Services.SchoolService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "report")
public class reportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value="getStudentReport",method = RequestMethod.GET)
    public void generateStudentReport() throws JRException, FileNotFoundException {
     reportService.generateStudentReport();
  }
    @RequestMapping(value="getMarkReport",method = RequestMethod.GET)
    public void generateMarkReport() throws JRException, FileNotFoundException {
        reportService.generateMarkReport();
    }

    @RequestMapping(method = RequestMethod.GET, value = "ReportForAverageMarks")
    public String generateReportForCourseMark() {
        try {
            return reportService.generateAverageMarkReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }

}
