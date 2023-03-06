package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.MarkRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    public List<Mark> getAllMarks(){

        return markRepository.getAllMarks();
    }


    public Mark getMarkById(Integer id){
        Mark mark= markRepository.getMarkById(id);
        return mark;
    }

    public List<Mark> getAllActiveMarks(){

        return markRepository.getAllActiveMarks();
    }

    public List<Mark> getAllInActiveMarks(){

        return markRepository.getAllInActiveMarks();
    }
    public List<Mark> getLatestRow(){

        return markRepository.getLatestRow();
    }
//    public void deleteMarkById(Integer id){
//        Mark markToDelete = markRepository.findById(id).get();
//        markRepository.delete(markToDelete);
//    }

    public void deleteMarkById(Integer id){
        Mark mark = markRepository.getMarkById(id);
        mark.setActive(false);
        markRepository.save(mark);
    }

    public void deleteAll(){
        Iterable<Mark> marks= markRepository.findAll();
        for(Mark mark:marks) {
            mark.setActive(false);
        }
        markRepository.saveAll(marks);
    }

    public List<Mark> getMarkCreatedAfterDate(String cratedDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(cratedDate);
        List<Mark> marks = markRepository.getMarkCreatedAfterDate(javaDate);
        return marks;
    }

    public Mark getMarkByCreatedDate(String cratedDate) {

        return markRepository.getMarkByCreatedDate(cratedDate);
    }



}

