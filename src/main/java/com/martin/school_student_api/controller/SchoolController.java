package com.martin.school_student_api.controller;

import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;
import com.martin.school_student_api.service.school.SchoolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<SchoolResponseDTO> createSchool (@Valid @RequestBody SchoolRequestDTO schoolRequestDTO) {
        SchoolResponseDTO response = schoolService.save(schoolRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
