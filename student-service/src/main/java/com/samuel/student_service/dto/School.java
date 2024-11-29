package com.samuel.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private Long id;
    private String schoolName;
    private String location;
    private String principalName;
}