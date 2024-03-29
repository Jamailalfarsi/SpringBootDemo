package com.example.demo.Models;



import javax.persistence.*;


@Entity
public class Course extends BaseEntity {

    @Id // Defining the Primary key
    // To make the primary key … just like "Identity/Auto Increment"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    // gives the column name/ if you want to make it different you can do it
    // by default everything is true
    @Column(name = "course_name")
    String name;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne // many courses to one student
    @JoinColumn(name = "student_id", referencedColumnName = "id")// defining the foreign key which is ID
    Student student;


//    @OneToMany
//    @JoinColumn(referencedColumnName = "id")// defining the foreign key which is ID
//    List<Mark> marks;

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

//    public List<Mark> getMarks() {
//        return marks;
//    }
//
//    public void setMarks(List<Mark> marks) {
//        this.marks = marks;
//    }

}