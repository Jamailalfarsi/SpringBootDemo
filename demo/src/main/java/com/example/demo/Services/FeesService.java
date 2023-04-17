package com.example.demo.Services;

import com.example.demo.Repositories.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeesService {
    @Autowired
    FeesRepository feesRepository;
}
