package com.example.demo.controllers;

import com.example.demo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
}
