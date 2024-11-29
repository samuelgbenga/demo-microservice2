package com.samuel.student_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private String name;
    private int age;
    private String gender;
    private Long schoolId;
}
