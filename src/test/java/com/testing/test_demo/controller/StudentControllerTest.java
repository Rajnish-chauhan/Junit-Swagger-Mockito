package com.testing.test_demo.controller;

import com.testing.test_demo.entity.Student;
import com.testing.test_demo.repo.StudentRepo;
import com.testing.test_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentService studentService;
    void shouldStudentAddSuccessfully(){
        Student s=new Student(null,"Ram","ram@gmail.com",22);
        Student saved=studentService.addStudent(s);
    }
}
