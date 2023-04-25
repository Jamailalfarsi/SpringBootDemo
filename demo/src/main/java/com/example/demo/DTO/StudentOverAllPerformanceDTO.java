package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentOverAllPerformanceDTO {
    String studentName;
    Integer studentAge;
    Integer studentId;
    public StudentOverAllPerformanceDTO(String studentName, Integer studentAge, Integer studentId) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentId = studentId;
    }





}
