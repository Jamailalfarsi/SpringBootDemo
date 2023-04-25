package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CountOfStudentWithSchoolDTO {
    public CountOfStudentWithSchoolDTO(Integer countOfStudents, String schoolName) {
        this.countOfStudents = countOfStudents;
        this.schoolName = schoolName;
    }

    Integer countOfStudents;
    String schoolName;
}
