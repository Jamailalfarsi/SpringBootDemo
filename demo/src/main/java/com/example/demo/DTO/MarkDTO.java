package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MarkDTO {
    public MarkDTO(String courseName, Integer obtainMark, String grad) {
        this.courseName = courseName;
        this.obtainMark = obtainMark;
        this.grade = grade;
    }


    String courseName;
    Integer obtainMark;
    String grade;
}
