package com.example.demo.controller;

import com.example.demo.entity.Search;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("Search", new Search());
        return "students";
    }

    @GetMapping("/students/register")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "createStudent";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = new Student(studentService.getStudentById(id));
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setMatricula(student.getMatricula());
        existingStudent.setCurso(student.getCurso());
        existingStudent.setUniversidade(student.getUniversidade());
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students/")
    public String searchStudent(@RequestParam(name = "search", required = false) Search search, Model model) {
        model.addAttribute("students", studentService.searchStudent(search.getSearch()));
        model.addAttribute("Search", search);
        return "students";
    }
}
//  disciplina curso universidade