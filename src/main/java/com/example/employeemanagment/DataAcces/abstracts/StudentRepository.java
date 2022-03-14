package com.example.employeemanagment.DataAcces.abstracts;

import com.example.employeemanagment.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByStudentId(Integer student_id);

    @Override
    void delete(Student student);

    List<Student> findByOrderByRegistationDate();


    @Override
    List<Student> findAll();

    List<Student> getByStudentNameContains(String student_name);

    List<Student> getByStudentName(String student_name);
}
