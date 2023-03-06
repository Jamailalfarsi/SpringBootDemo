package com.example.demo.controllers;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
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
    public Mark getMarkByCreatedDate(@RequestParam Date cratedDate){
        Mark mark=markService.getMarkByCreatedDate(cratedDate);
        return mark;
    }

    @RequestMapping(value="getSchoolByUpdatedDate",method = RequestMethod.GET)
    public Mark getMarkByUpdatedDate(@RequestParam Date updatedDate){
        Mark mark=markService.getMarkByUpdatedDate(updatedDate);
        return mark;
    }
    @RequestMapping(value = "deleteMarkByCreatedDate", method = RequestMethod.POST)
    public void deleteMarkByCreatedDate(@RequestParam String cratedDate) throws ParseException {
        markService.deleteMarkByCreatedDate(cratedDate);

    }
    @RequestMapping(value = "deleteMarkByUpdatedDate", method = RequestMethod.POST)
    public void deleteMarkByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        markService.deleteMarkByUpdatedDate(updatedDate);

    }
}
