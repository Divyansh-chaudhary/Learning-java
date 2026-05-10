package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void save(Student student) {
        studentRepo.save(student);
    }
    public List<Student> getAll() {
        return studentRepo.findAll();
    }
}
