package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student st ){
        Student student  = studentService.addStudent(st);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> allFreelancer = studentService.getAll();
        return new ResponseEntity<>(allFreelancer,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFrrealnce(@PathVariable Integer id){
        studentService.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody Student st ){
        Student student = studentService.login(st);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

}
