package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freelancer;

@Service
public interface StudentService {

    public Student addStudent(Student s);

    public List<Student>getAll();

    public void deleteById(Integer id);

    Student getStudentByEmailId(String emailId);

    Student login(Student fr);

}
