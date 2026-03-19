package com.testing.test_demo.controller;

import com.testing.test_demo.entity.Student;
import com.testing.test_demo.repo.StudentRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepo repo;

    @BeforeEach
    void cleanDB(){
        repo.deleteAll();
    }
    @Autowired
    private ObjectMapper mapper;



    @Test
    void shouldCreateStudent() throws Exception{
        Student student=new Student(null,"test","test123@gamil.com",22);
        mockMvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"));

    }


}
