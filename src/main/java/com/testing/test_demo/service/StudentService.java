package com.testing.test_demo.service;

import com.testing.test_demo.entity.Student;
import com.testing.test_demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student addStudent(Student student) {
    if(studentRepo.existsByEmail((student.getEmail()))){
        throw new IllegalArgumentException("Email Already Existes");
        }
        return studentRepo.save(student);
    }

    public void DeleteStudent(Long id){
        studentRepo.deleteById (id);
    }
}
