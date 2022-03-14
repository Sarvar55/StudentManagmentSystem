package com.example.student.controller.api;

import com.example.student.business.abstratcs.StudentServices;
import com.example.student.entity.Student;
import com.example.student.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/api/v1/home")
public class StudentController {

    private StudentServices services;
    @Autowired
    public StudentController(StudentServices services) {
        this.services = services;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return services.findAll();
    }

    @PostMapping("/students/add")
    public Student createStudent(@RequestBody Student student) {
        return services.createStudent(student);
    }

    @PutMapping("/students/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody Student studentDetails) throws StudentNotFoundException {
        Student student = services.getByStudentId(studentId).
                orElseThrow(() -> new StudentNotFoundException("Students not exist with id : " + studentId));

        student.setStudentName(studentDetails.getStudentName());
        student.setStudentLastName(studentDetails.getStudentLastName());
        student.setStudentClassName(studentDetails.getStudentClassName());
        student.setRegistationDate(studentDetails.getRegistationDate());

        Student updateStudent = services.createStudent(student);
        return ResponseEntity.ok(updateStudent);
    }

    @GetMapping("/students/findId/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) throws StudentNotFoundException {
        Student student = services.getByStudentId(studentId).
                orElseThrow(() -> new StudentNotFoundException("Students not exist with studentId : " + studentId));

        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/delete/{studentId}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int studentId) throws StudentNotFoundException {
        Student student = services.getByStudentId(studentId).
                orElseThrow(() -> new StudentNotFoundException("Students not exist with studentId : " + studentId));

        services.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }

        @GetMapping("/students/findName/{studentName}")
    public ResponseEntity<List<Student>> getByStudentName(@PathVariable String studentName) throws StudentNotFoundException {

        List<Student> student=services.getByStudentName(studentName).
                orElseThrow(()->new StudentNotFoundException("Students not exist with studentName :"+studentName));
        return ResponseEntity.ok(student);
    }
}
