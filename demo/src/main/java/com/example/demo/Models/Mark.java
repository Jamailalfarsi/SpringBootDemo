package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mark {
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
}
