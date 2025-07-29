package com.martin.school_student_api.controller;

import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;
import com.martin.school_student_api.service.school.SchoolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public ResponseEntity<SchoolResponseDTO> updateSchool (@PathVariable Long id, @Valid @RequestBody SchoolRequestDTO schoolRequestDTO) {
        Optional<SchoolResponseDTO> response = schoolService.update(id, schoolRequestDTO);

        return response.map(schoolResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(schoolResponseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @GetMapping
    public ResponseEntity<List<SchoolResponseDTO>> getSchools () {
        List<SchoolResponseDTO> response = schoolService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
