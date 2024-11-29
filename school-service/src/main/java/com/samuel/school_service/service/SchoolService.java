package com.samuel.school_service.service;


import com.samuel.school_service.dto.SchoolDto;
import com.samuel.school_service.entity.School;
import com.samuel.school_service.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public School addSchool(SchoolDto school){

        School newSchool = new School();
        newSchool.setSchoolName(school.getSchoolName());
        newSchool.setLocation(school.getLocation());
        newSchool.setPrincipalName(school.getPrincipalName());
        return schoolRepository.save(newSchool);
    }
    public List<School> fetchSchools(){
        return schoolRepository.findAll();
    }
    public School fetchSchoolById(Long id){
        return schoolRepository.findById(id).orElse(null);
    }
}
