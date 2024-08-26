package com.example.MongoDB.controller;

import com.example.MongoDB.model.Student;
import com.example.MongoDB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/v1/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity("Student Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/student")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>("Student Updated Successfully", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/v1/student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student Deleted Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/v1/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }
}
