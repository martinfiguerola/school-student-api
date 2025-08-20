package com.martin.school_student_api.controller;

import com.martin.school_student_api.dto.student.StudentDetailDTO;
import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;
import com.martin.school_student_api.service.student.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<StudentResponseDTO>> getStudents (Pageable pageable) {
        Page<StudentResponseDTO> responseDTOS = studentService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDetailDTO> getStudent(@PathVariable Long id) {
        Optional<StudentDetailDTO> responseDTO = studentService.findById(id);
        return responseDTO.map(studentDetailDTO -> ResponseEntity.status(HttpStatus.OK).body(studentDetailDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent (@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        Optional<StudentResponseDTO> dtoOptional = studentService.update(id, studentRequestDTO);

        return dtoOptional
                .map(studentResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id) {
        if (studentService.delete(id)) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with given ID does not exist.");
    }
}
