package com.example.demo.Models;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity


public class Student {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="student_name")
    String name;
    Integer age;

    @ManyToOne
    @JoinColumn(name="school_id",referencedColumnName = "id")
    @Autowired
    School school;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
