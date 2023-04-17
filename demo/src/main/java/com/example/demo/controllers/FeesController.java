package com.example.demo.controllers;

import com.example.demo.Models.Fees;
import com.example.demo.Models.School;
import com.example.demo.Repositories.FeesRepository;
import com.example.demo.Services.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeesController {
    @Autowired
    FeesService feesService;

    @RequestMapping(value = "getAll")
    public List<Fees> getAllFeeses() {
        List<Fees> feeses = new ArrayList<>();
        feeses = feesService.getAllFeeses();
        return feeses;
    }
}
