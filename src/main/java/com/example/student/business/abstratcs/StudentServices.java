package com.example.employeemanagment.business.abstratcs;

import com.example.employeemanagment.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentServices {
    Optional<Student> getByStudentId(Integer student_id);

    List<Student> findByOrderByRegistationDate();

    Student createStudent(Student student);

    void delete(Student student);

    List<Student> findAll();

    List<Student> getByStudentNameContains(String student_name);

    Optional<List<Student>> getByStudentName(String student_name);

}
