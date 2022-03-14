package com.example.employeemanagment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_last_name")
    private String studentLastName;

    @Column(name = "student_class_name")
    private String studentClassName;

    @Column(name = "registation_date")
    private Date registationDate;

}
