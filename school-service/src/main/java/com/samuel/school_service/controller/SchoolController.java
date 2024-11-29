package com.samuel.school_service.controller;

import com.samuel.school_service.dto.SchoolDto;
import com.samuel.school_service.entity.School;
import com.samuel.school_service.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody SchoolDto school){
        return schoolService.addSchool(school);
    }
    @GetMapping
    public List<School> fetchSchools(){
        return  schoolService.fetchSchools();
    }
    @GetMapping("/{id}")
    public School fetchSchoolById(@PathVariable Long id){
        return schoolService.fetchSchoolById(id);
    }
}
