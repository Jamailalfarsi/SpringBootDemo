package com.example.demo.controllers;

import com.example.demo.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="mark")
public class MarkController {
    @Autowired
    MarkService markService;

}
