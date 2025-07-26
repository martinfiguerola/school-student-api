package com.martin.school_student_api.repository;

import com.martin.school_student_api.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
