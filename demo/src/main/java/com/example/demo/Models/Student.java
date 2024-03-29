package com.example.demo.Models;

import javax.persistence.*;


@Entity // This annotation "entity" tells spring boot that this class is going to be a table in sql
//@Table(name = "dbo.Student")
public class Student extends BaseEntity{




    @Id // Defining the Primary key
    // To make the primary key … just like "Identity/Auto Increment"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    // gives the column name/ if you want to make it different you can do it
    // by default everything is true
    @Column(name = "student_name")
    String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    Integer age;
//    String rollNumber;

    public void setSchool(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }
//    @OneToMany
//    @JoinColumn(referencedColumnName = "id")// defining the foreign key which is ID
//    List<Course> courses;

    @ManyToOne // doing the relation to the school where many student go to 1 school
    @JoinColumn(name = "school_id", referencedColumnName = "id")// defining the foreign key which is ID
    School school;
    // (we are doing it here because we want the id to be in student)
    // creating a school object

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getRollNumber() {
//        return rollNumber;
//    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

//    public void setRollNumber(String rollNumber) {
//        this.rollNumber = rollNumber;


   // }
}