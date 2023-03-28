package com.example.demo.controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import lombok.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static java.util.Date.*;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
    @Test
    void getSchoolById2() throws  Exception{
        String schoolName=schoolController.getSchoolById(3).getName();
        assertEquals("N",schoolName);

    }
    @Test
    void getSchoolByIdWhenIdZerro()throws Exception{
//        School schoolToTest=schoolController.getSchoolById(0);
//        assertEquals(null,schoolToTest);

    }



    @Test
    void getBySchoolName() {


    }

    @Test
    void getAllActiveSchools() throws  Exception{
        List<School> School=schoolController.getBySchoolName("L");
        for(School sch:School){
            assertEquals(1,sch.getId());
        }

    }
    @Test
    void getAllActiveSchools1() {
//        Boolean schoolActive=schoolController.getSchoolById(2).getActive();
//        assertEquals("true",schoolActive);

    }
    @Test
    void getAllActiveSchools2() {
//        Boolean schoolActive=schoolController.getSchoolById(3).getActive();
//        assertEquals("true",schoolActive);

    }
//    @Test
//    void getSchoolActiveThrowsErrorOnInvalid()throws  Exception{
////        assertThrows(Exception.class, (Executable) schoolController.getSchoolById(0));
//        School schoolToTest=schoolController.getSchoolById(0);
//        assertEquals(null,schoolToTest);
//    }
//@Test
//void getItemByIdThrowsErrorOrInvalidId() throws Exception {
//    assertThrows(Exception.class, (Executable) schoolController.getSchoolById(0));
//}


    @Test
    void getAllInActiveSchools() {
//       Boolean schoolActive=schoolController.getSchoolById(4).getActive();
//       assertEquals("false",schoolActive);

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
    void getSchoolByCreatedDate1()throws  Exception {
//        School schoolToTest;
//        schoolToTest = schoolController.getSchoolByCreatedDate(valueOf("2022-01-01"));
//        String schoolName=schoolToTest.getName();
//        assertEquals("L",schoolName);
    }

    @Test
    void getSchoolByUpdatedDate() {
    }
}