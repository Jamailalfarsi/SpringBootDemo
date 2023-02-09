package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Course {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
   @Column(name="course_name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name="student_id",referencedColumnName = "id")
    Student student;
//    List<Mark>marks;
//
//    public List<Mark> getMarks() {
//        return marks;
//    }
//
//    public void setMarks(List<Mark> marks) {
//        this.marks = marks;
//    }
}
