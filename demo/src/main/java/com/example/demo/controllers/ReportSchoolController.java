package com.example.demo.controllers;

import com.example.demo.Services.ReportService;
import com.example.demo.Services.SchoolService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

public class ReportSchoolController {
    @Autowired
    ReportService reportService;
    @RequestMapping(value="report")
    public String generateSchoolReport()throws JRException, FileNotFoundException {
       return reportService.generateReport();
    }

}
