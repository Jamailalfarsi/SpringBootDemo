package com.example.demo.DTO;

import com.example.demo.Models.School;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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


    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    School school;

}
