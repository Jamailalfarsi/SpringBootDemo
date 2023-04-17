package com.example.demo.Services;

import com.example.demo.Models.Fees;
import com.example.demo.Models.School;
import com.example.demo.Repositories.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FeesService {
    @Autowired
    FeesRepository feesRepository;

    public List<Fees> getAllFeeses() {
        return feesRepository.getAllFeeses();
    }

    public Fees getFeesById(Integer id) {
        return feesRepository.getFeesById(id);

    }
    public Fees getFeesBydatePaid(Date datePaid) {
        return feesRepository.getFeesBydatePaid(datePaid);
    }



}

