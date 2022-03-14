package com.example.employeemanagment.business.concretes;

import com.example.employeemanagment.DataAcces.abstracts.StudentRepository;
import com.example.employeemanagment.business.abstratcs.StudentServices;
import com.example.employeemanagment.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentManager implements StudentServices {

    private StudentRepository repository;

    @Autowired
    public StudentManager(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Student> getByStudentId(Integer student_id) {
        return Optional.ofNullable(repository.findByStudentId(student_id));
    }

    @Override
    public List<Student> findByOrderByRegistationDate() {
        return repository.findByOrderByRegistationDate();
    }

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(Student student) {
        repository.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> getByStudentNameContains(String student_name) {
        return repository.getByStudentNameContains(student_name);
    }
    @Override
    public Optional<List<Student>> getByStudentName(String student_name) {
        return Optional.ofNullable(repository.getByStudentName(student_name));
    }
}
