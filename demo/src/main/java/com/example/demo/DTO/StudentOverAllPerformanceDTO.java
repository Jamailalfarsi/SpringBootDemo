package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentOverAllPerformanceDTO {
    String studentName;
    String studentRollNumber;
    Integer studentId;
    public StudentOverAllPerformanceDTO(String studentName, String studentRollNumber, Integer studentId) {
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
        this.studentId = studentId;
    }


}
