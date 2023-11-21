package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "matricula", nullable = true, length = 50)
    private String matricula;

    @Column(name = "curso", nullable = true, length = 50)
    private String curso;

    @Column(name = "Universidade", nullable = true, length = 50)
    private String universidade;

    public Student() {
    }

    public Student(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.matricula = student.getMatricula();
        this.curso = student.getCurso();
        this.universidade = student.getUniversidade();
    }

    public Student(Long id, String firstName, String lastName, String email, String matricula, String curso, String universidade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName= lastName;
        this.email = email;
        this.matricula = matricula;
        this.curso = curso;
        this.universidade = universidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCurso(){
        return curso;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getUniversidade(){
        return universidade;
    }
}

