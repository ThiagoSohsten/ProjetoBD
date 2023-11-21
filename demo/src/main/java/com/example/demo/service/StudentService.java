package com.example.demo.service;


import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void deleteStudent(Long id);

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    List<Student> searchStudent(String search);
}

