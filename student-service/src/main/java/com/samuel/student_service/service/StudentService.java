package com.samuel.student_service.service;


import com.samuel.student_service.dto.School;
import com.samuel.student_service.dto.StudentDto;
import com.samuel.student_service.dto.StudentResponse;
import com.samuel.student_service.entity.Student;
import com.samuel.student_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final RestTemplate restTemplate;

    public ResponseEntity<?> createStudent(StudentDto student){

        Student newStudent = new Student();
        newStudent.setAge(student.getAge());
        newStudent.setName(student.getName());
        newStudent.setGender(student.getGender());
        newStudent.setSchoolId(student.getSchoolId());


        try{
            return new ResponseEntity<Student>(studentRepository.save(newStudent), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchStudentById(Long id){
        Optional<Student> student =  studentRepository.findById(id);
        if(student.isPresent()){
            School school = restTemplate.getForObject("http://SCHOOL-SERVICE/school/" + student.get().getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getGender(),
                    school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<?> fetchStudents(){
        List<Student> students = studentRepository.findAll();
        if(students.size() > 0){
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
    }
}
