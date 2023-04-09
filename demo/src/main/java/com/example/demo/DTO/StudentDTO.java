package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Data
@Getter
@Setter
public class StudentDTO {
    public StudentDTO(String schoolName, String studentName, Integer age) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.age = age;
    }


    String schoolName;
    String studentName;
    Integer age;


}
