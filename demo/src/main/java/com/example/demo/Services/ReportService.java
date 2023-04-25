package com.example.demo.Services;
import com.example.demo.DTO.CourseAverageMarkDTO;
import com.example.demo.DTO.MarkDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.TopPreformingStudentDTO;
import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.CourseRepository;
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
public class ReportService {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    CourseRepository courseRepository;

    public static final String pathToReports = "C:\\Users\\user021\\Desktop\\report";

    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_management.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Jamail");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf");
        return "Report generated : " + pathToReports + "\\schools.pdf";
    }


    public String generateStudentReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student std : studentList) {
            String schoolName = std.getSchool().getName();
            String studentName = std.getName();
            Integer studentAge = std.getAge();

            StudentDTO studentDTO = new StudentDTO(schoolName, studentName, studentAge);
            studentDTOList.add(studentDTO);

        }


        File file = ResourceUtils.getFile("classpath:School_AssociatedStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Jamail");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\student.pdf");
        return "Report generated : " + pathToReports + "\\student.pdf";
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
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\mark.pdf");
        return "Report generated : " + pathToReports + "\\mark.pdf";
    }

    public String generateAverageMarkReport() throws FileNotFoundException, JRException {

        List<Course> courseList = courseRepository.getAllCourses();
        List<CourseAverageMarkDTO> courseMarkDTOList = new ArrayList<>();
        for (Course course : courseList) {
            String courseName = course.getName();
            Integer averageMark = markRepository.getAverageOfMarksByCourseName(courseName);
            courseMarkDTOList.add(new CourseAverageMarkDTO(courseName, averageMark));
        }


        File file = ResourceUtils.getFile("classpath:Course_AverageMark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkDTOList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Jamail");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\courseAverageMark.pdf");
        return "Report generated : " + pathToReports + "\\courseAverageMark.pdf";

    }

    public String generateTopPerformingStudentReport() throws FileNotFoundException, JRException  {

        List<School> schoolList = schoolRepository.getAllSchools();
        Map<School, Student> schoolStudentMap = new HashMap<>();
        List<TopPreformingStudentDTO> topPreformingStudentDTOSList = new ArrayList<>();

        for (School school : schoolList) {
            List<Student> studentList = studentRepository.getStudentsBySchoolId(school.getId());
            Integer highestMarks = 0;
            Student studentWithHighestMarks = new Student();
            for (Student student : studentList) {
                Integer studentId = student.getId();
                Integer studentTotalMark = markRepository.getSumOfMarksByStudentId(studentId);
                if (studentTotalMark > highestMarks) {
                    highestMarks = studentTotalMark;
                    studentWithHighestMarks = student;
                }
            }
            schoolStudentMap.put(school, studentWithHighestMarks);
            topPreformingStudentDTOSList.add(new TopPreformingStudentDTO(school.getName(), studentWithHighestMarks.getName()));
        }
        File file = ResourceUtils.getFile("classpath:Top_Preforming_Student.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPreformingStudentDTOSList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Jamail");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPreformingStudent.pdf");
        return "Report generated : " + pathToReports + "\\TopPreformingStudent.pdf";
    }
}





