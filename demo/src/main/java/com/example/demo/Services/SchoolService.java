//package com.example.demo.Services;
//
//import com.example.demo.Models.School;
//import com.example.demo.Models.Student;
//import com.example.demo.Repositories.SchoolRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Service
//
//public class SchoolService {
//    @Autowired
//    SchoolRepository schoolRepository;
//
//    public List<School> getAllSchools() {
//        return schoolRepository.getAllSchools();
//    }
//
//    public School getSchoolById(Integer id) {
//        return schoolRepository.getSchoolById(id);
//
//    }
//
//    public School getBySchoolName(String school_name) {
//
//        return schoolRepository.getBySchoolName(school_name);
//    }
//
//    public List<School> getAllActiveSchools() {
//
//        return schoolRepository.getAllActiveSchools();
//    }
//
//    public List<School> getAllInActiveSchools() {
//
//        return schoolRepository.getAllInActiveSchools();
//    }
//
//    public List<School> getLatestRow() {
//
//        return schoolRepository.getLatestRow();
//    }
//
//    public List<School> getLatestUpdated() {
//
//        return schoolRepository.getLatestUpdated();
//    }
//
//    //    public void deleteSchoolById(Integer id){
////        School schoolToDelete = schoolRepository.findById(id).get();
////        schoolRepository.delete(schoolToDelete);
////    }
//    public void setCreateDateByUserInput(String stringDate, Integer id) throws ParseException {
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date javaDate = formatter.parse(stringDate);
//        School school = schoolRepository.getSchoolById(id);
//        schoolRepository.save(school);
//    }
//
//    public void deleteSchoolById(Integer id) {
//        School school = schoolRepository.getSchoolById(id);
//        school.setActive(false);
//        schoolRepository.save(school);
//    }
//
//    public void deleteBySchoolName(String school_name) {
//        School school = schoolRepository.getBySchoolName(school_name);
//        school.setActive(false);
//        schoolRepository.save(school);
//    }
//
//    public void deleteAll() {
//        Iterable<School> schools = schoolRepository.findAll();
//        for (School school : schools) {
//            school.setActive(false);
//        }
//        schoolRepository.saveAll(schools);
//    }
//
//    public List<School> getSchoolCreatedAfterDate(String cratedDate) throws ParseException {
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date javaDate = formatter.parse(cratedDate);
//        List<School> schools = schoolRepository.getSchoolCreatedAfterDate(javaDate);
//        return schools;
//    }
//
//    public School getSchoolByCreatedDate(Date cratedDate) {
//        return schoolRepository.getSchoolByCreatedDate(cratedDate);
//    }
//    public School getSchoolByUpdatedDate(Date updatedDate) {
//        return schoolRepository.getSchoolByUpdatedDate(updatedDate);
//    }
//    public void deleteSchoolsByCreatedDate(String cratedDate) throws ParseException{
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date javaDate = formatter.parse(cratedDate);
//        School school = schoolRepository.getSchoolByCreatedDate(javaDate);
//        school.setActive(false);
//        schoolRepository.save(school);
//    }
//    public void deleteSchoolsByUpdatedDate(String updatedDate) throws ParseException{
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date javaDate = formatter.parse(updatedDate);
//        School school = schoolRepository.getSchoolByUpdatedDate(javaDate);
//        school.setActive(false);
//        schoolRepository.save(school);
//    }
//    public void  createSchool(String school_name) {
//        School school=new School();
//        school.setName(school_name);
//        school.setActive(true);
//        school.setCratedDate(new Date());
//        schoolRepository.save(school);
//    }
//
//    public void updateSchool(Integer id,String school_name,Boolean isActive){
//        School school =schoolRepository.getSchoolById(id);
//        school.setName(school_name);
//        school.setCratedDate(new Date());
//        school.setActive(true);
//        schoolRepository.save(school);
//    }
//
//
//
//
//
//}
