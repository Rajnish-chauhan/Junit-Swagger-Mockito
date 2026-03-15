package com.testing.test_demo.repo;

import com.testing.test_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
      boolean existsByEmail(String email);
    }


