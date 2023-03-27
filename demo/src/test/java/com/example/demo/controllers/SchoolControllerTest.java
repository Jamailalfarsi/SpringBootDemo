package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SchoolControllerTest {
    @Autowired
    SchoolController schoolController;

    @Test
    void getAllSchools() {
    }

    @Test
    void getSchoolById() {
        String schoolName=schoolController.getSchoolById(1).getName();
        assertEquals("L",schoolName);
    }

    @Test
    void getBySchoolName() {
    }

    @Test
    void getAllActiveSchools() {
    }

    @Test
    void getAllInActiveSchools() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void getLatestUpdated() {
    }

    @Test
    void setCreateDateByUserInput() {
    }

    @Test
    void deleteSchoolById() {
    }

    @Test
    void deleteBySchoolName() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void getSchoolCreatedAfterDate() {
    }

    @Test
    void getSchoolByCreatedDate() {
    }

    @Test
    void getSchoolByUpdatedDate() {
    }
}