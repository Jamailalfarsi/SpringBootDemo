package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CourseWithGradesDTO {
    String courseName;
    Integer countOfMarks;
    String grade;
    public CourseWithGradesDTO(String courseName, Integer countOfMarks, String grade) {
        this.courseName = courseName;
        this.countOfMarks = countOfMarks;
        this.grade = grade;
    }


}
