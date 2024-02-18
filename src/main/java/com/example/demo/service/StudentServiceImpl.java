package com.example.demo.service;

import com.example.demo.exception.AuthenticationException;
import com.example.demo.model.Freelancer;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentrepository;
    @Override
    public Student addStudent(Student s) {
        Student st = studentrepository.save(s);
        return st;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = studentrepository.findAll();
        return students;
    }

    @Override
    public void deleteById(Integer id) {
        studentrepository.deleteById(id);

    }

    @Override
    public Student getStudentByEmailId(String emailId) {
        return studentrepository.findByEmailId(emailId);
    }

    @Override
    public Student login(Student fr) {
        //Step 1 : Get free lancer object by email id => If found, then match password : else throw error
        //Step 2 : If found then match password
        //Step 3 : If password matched, then  return freelancer object, with success
        //Step 4 : If password not matched, send password wrong error

        Student fetchedStudent = studentrepository.findByEmailId(fr.getEmailId());
        if (null != fetchedStudent) {
            //Match password
            String passwordFromDb = fetchedStudent.getPassword();
            if (passwordFromDb.equals(fr.getPassword())) {
                return fetchedStudent;
            } else {
                throw new AuthenticationException(HttpStatus.NOT_FOUND, "Password wrong");
            }
        } else {
            throw new AuthenticationException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

}
