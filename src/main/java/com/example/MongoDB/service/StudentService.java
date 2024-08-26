package com.example.MongoDB.service;

import com.example.MongoDB.model.Student;
import com.example.MongoDB.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        if(getStudentById(student.getId()) != null)
            deleteStudent(student.getId());
        addStudent(student);
        return student;
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
