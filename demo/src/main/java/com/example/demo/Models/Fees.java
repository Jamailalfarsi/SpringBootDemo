package com.example.demo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

public class Fees extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Float amount;

    Date datePaid;
    @OneToOne
    @JoinColumn(name = "fees_id", referencedColumnName = "id")// defining the foreign key which is ID
    Student student;
}
