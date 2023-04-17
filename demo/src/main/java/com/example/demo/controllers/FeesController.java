package com.example.demo.controllers;

import com.example.demo.Repositories.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeesController {
    @Autowired
    FeesRepository feesRepository;
}
