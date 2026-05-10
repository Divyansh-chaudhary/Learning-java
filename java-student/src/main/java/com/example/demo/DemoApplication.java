package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        StudentService studentService = context.getBean(StudentService.class);
        Student student = context.getBean(Student.class);

        student.setName("Chetan");
        student.setId(2);
        student.setMarks(32);
        studentService.save(student);

        List<Student> students = studentService.getAll();
        System.out.println(students);
	}

}
