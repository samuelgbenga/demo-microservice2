package com.samuel.school_service.repository;

import com.samuel.school_service.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SchoolRepository extends JpaRepository<School, Long> {
}
