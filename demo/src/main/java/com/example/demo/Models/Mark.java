package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class Mark extends BaseEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getObtainedMark() {
        return obtainedMark;
    }

    public void setObtainedMark(Integer obtainedMark) {
        this.obtainedMark = obtainedMark;
    }

    Integer obtainedMark;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    String grade;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;


}
