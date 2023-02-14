package com.example.demo.controllers;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @RequestMapping(value = "getAllMarkByIsInActive")
    public List<Mark> getAllInActiveMarks(){
        List<Mark>  InactiveMarksList = markService.getAllInActiveMarks();
        return InactiveMarksList;
    }

}
