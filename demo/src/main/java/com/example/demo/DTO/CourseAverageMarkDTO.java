package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor

public class CourseAverageMarkDTO {
    String courseName;
    Integer obtainedMarks;
    String grade;
    Integer averageMark;


    public CourseAverageMarkDTO(String courseName, Integer averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }


}

