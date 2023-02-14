package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class School extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="school_name")
    String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany
//    @JoinColumn(referencedColumnName = "id")
//   List<Student> student;
//    public List<Student> getStudent() {
//        return student;
//    }
//
//    public void setStudent(List<Student> student) {
//        this.student = student;
//    }


}
