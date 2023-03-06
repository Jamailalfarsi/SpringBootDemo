package com.example.demo.controllers;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value="mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @RequestMapping(value = "getAllMarkByIsInActive")
    public List<Mark> getAllInActiveMarks() {
        List<Mark> InactiveMarksList = markService.getAllInActiveMarks();
        return InactiveMarksList;
    }

    @RequestMapping(value = "getAllMarkByLastRow")
    public List<Mark> getLatestRow() {
        List<Mark> orderMarksList = markService.getLatestRow();
        return orderMarksList;
    }
//    @GetMapping(value = "deleteById")
//    public String deleteMarkById(@RequestParam Integer id) {
//
//        markService.deleteMarkById(id);
//        return "Record Deleted Successfully :)";
//
//    }

    @GetMapping(value = "deleteById")
    public void deleteMarkById(@RequestParam Integer id) {

        markService.deleteMarkById(id);

    }

    @GetMapping(value = "deleteAll")
    public void deleteAll() {
        markService.deleteAll();

    }

    @GetMapping(value = "markCreatedAfterDate")
    public List<Mark> getMarkCreatedAfterDate(@RequestParam String cratedDate) throws ParseException {
        List<Mark> marks = markService.getMarkCreatedAfterDate(cratedDate);
        return marks;
    }
    @RequestMapping(value="getMarkByCreatedDate",method = RequestMethod.GET)
    public Mark getMarkByCreatedDate(@RequestParam String cratedDate){
        Mark mark=markService.getMarkByCreatedDate(cratedDate);
        return mark;
    }
}
