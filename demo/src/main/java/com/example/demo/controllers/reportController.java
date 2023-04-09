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

}
