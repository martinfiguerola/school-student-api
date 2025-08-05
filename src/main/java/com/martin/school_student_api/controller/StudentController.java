package com.martin.school_student_api.controller;

import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;
import com.martin.school_student_api.service.student.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent (@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        StudentResponseDTO studentResponseDTO = studentService.save(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponseDTO);

    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents () {
        List<StudentResponseDTO> responseDTOS = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long id) {
        Optional<StudentResponseDTO> responseDTO = studentService.findById(id);
        return responseDTO.map(studentResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
