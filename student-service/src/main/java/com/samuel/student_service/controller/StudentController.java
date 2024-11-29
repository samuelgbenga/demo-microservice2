package com.samuel.student_service.controller;

import com.samuel.student_service.dto.StudentDto;
import com.samuel.student_service.entity.Student;
import com.samuel.student_service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudentById(@PathVariable Long id){
        return studentService.fetchStudentById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchStudents(){
        return studentService.fetchStudents();
    }
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDto student){
        return studentService.createStudent(student);
    }

}