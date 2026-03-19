package com.testing.test_demo.controller;

import com.testing.test_demo.entity.Student;
import com.testing.test_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        System.out.println("Calling by Test");
        return  studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.DeleteStudent(id);
    }
}
