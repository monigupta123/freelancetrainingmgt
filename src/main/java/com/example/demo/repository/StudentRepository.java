package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Freelancer;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    Student findByEmailId(String emailId);


}
