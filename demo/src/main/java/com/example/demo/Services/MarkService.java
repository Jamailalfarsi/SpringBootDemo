package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.MarkRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}

