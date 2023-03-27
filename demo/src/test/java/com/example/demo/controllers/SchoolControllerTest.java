package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SchoolControllerTest {
    @Autowired
    SchoolController schoolController;

    @Test
    void getAllSchools() {
    }

    @Test
    void getSchoolById() throws  Exception{
        String schoolName=schoolController.getSchoolById(1).getName();
        assertEquals("L",schoolName);

    }
    @Test
    void getSchoolById1() throws  Exception{
        String schoolName=schoolController.getSchoolById(2).getName();
        assertEquals("M",schoolName);

    }
    void getSchoolById2() throws  Exception{
        String schoolName=schoolController.getSchoolById(3).getName();
        assertEquals("N",schoolName);

    }

    @Test
    void getSchoolByIdThrowsErrorOnInvalid()throws  Exception{
        assertThrows(Exception.class, (Executable) schoolController.getSchoolById(30));
    }

    @Test
    void getBySchoolName() {
    }

    @Test
    void getAllActiveSchools() {
        Boolean schoolActive=schoolController.getSchoolById(1).getActive();
        assertEquals("true",schoolActive);


    }
    void getAllActiveSchools1() {
        Boolean schoolActive=schoolController.getSchoolById(2).getActive();
        assertEquals("true",schoolActive);

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