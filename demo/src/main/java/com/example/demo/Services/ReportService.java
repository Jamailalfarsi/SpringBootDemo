package com.example.demo.Services;
import com.example.demo.DTO.MarkDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.MarkRepository;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService  {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MarkRepository markRepository;

    public static final String pathToReports = "C:\\Users\\user021\\Desktop\\report";
    public String generateReport() throws FileNotFoundException, JRException {
    List<School> schoolList = schoolRepository.getAllSchools();

    File file = ResourceUtils.getFile("classpath:School_management.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
    Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Jamail");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
}


    public String generateStudentReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();
        List<StudentDTO> studentDTOList=new ArrayList<>();
        for (Student std:studentList ) {
            String schoolName = std.getSchool().getName();
            String studentName = std.getName();
            Integer studentAge =std.getAge();

            StudentDTO studentDTO=new StudentDTO(schoolName,studentName,studentAge);
            studentDTOList.add(studentDTO);

        }


        File file = ResourceUtils.getFile("classpath:School_AssociatedStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Jamail");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\student.pdf");
        return "Report generated : " + pathToReports+"\\student.pdf";
    }
    public String generateMarkReport() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();
        List<MarkDTO> MarkDTOList = new ArrayList<>();
        for (Mark markListVariable : markList) {
            String courseName = markListVariable.getCourse().getName();
            Integer obtainMarks = markListVariable.getObtainMark();
            String studentGrade = markListVariable.getGrade();
            MarkDTO markDTO = new MarkDTO(courseName, obtainMarks, studentGrade);
            MarkDTOList.add(markDTO);
        }


        File file = ResourceUtils.getFile("classpath:Course_Mark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(MarkDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Jamail");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\mark.pdf");
        return "Report generated : " + pathToReports+"\\mark.pdf";
    }

}
