package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class School extends BaseEntity{
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




}