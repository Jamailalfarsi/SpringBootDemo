package com.example.demo.DTO;

import com.example.demo.Models.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Getter
@Setter
public class MarkDTO {
    String courseName;
    Integer obtainMark;
    String grade;

    @ManyToOne // many courses to one student
    @JoinColumn(name = "student_id", referencedColumnName = "id")// defining the foreign key which is ID
    Student student;
}
