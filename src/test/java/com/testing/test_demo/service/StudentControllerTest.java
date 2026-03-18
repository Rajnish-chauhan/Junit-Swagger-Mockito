package com.testing.test_demo.service;

import com.testing.test_demo.entity.Student;
import com.testing.test_demo.repo.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentService studentService;

    @BeforeEach
    void cleanUp() {
        studentRepo.deleteAll();
    }

    @Test
    @Order(1)
    void shouldStudentAddSuccessfully(){
        Student s=new Student(null,"salu","salu@gmail.com",22);
        Student saved=studentService.addStudent(s);
        assertNotNull(saved.getId());
        assertEquals("salu",saved.getName());

    }

    @Test
    @Order(2)
    void shouldFetchStudents(){
        studentService.addStudent(new Student(null,"Syam","syam@gmail.com",14));
        studentService.addStudent(new Student(null,"yam","yam@gmail.com",15));
        studentService.addStudent(new Student(null,"ram","ram@gmail.com",16));

        /*If data is already exists in your Db or you already know your data in your DB then you will go following otherwise you accordingly add data
rst and now further perform this*/
        List<Student>list=studentService.getAll();
        assertEquals(3,list.size());
}

@Test
@Order(3)
void throghExceptionForDuplicateForEmail(){
 studentService.addStudent(new Student(null,"xyz1","xyz1123@gmail.com",19));
 IllegalArgumentException illegalArgumentException= assertThrows(
         IllegalArgumentException.class,
         ()->studentService.addStudent(new Student(null,"xyz1","xyz1123@gmail.com",26))
 );
 assertEquals("Email Already Existes",illegalArgumentException.getMessage());
}
}