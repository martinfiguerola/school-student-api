package com.martin.school_student_api.service.student;

import com.martin.school_student_api.domain.Student;
import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;
import com.martin.school_student_api.mapper.student.StudentDTOMapper;
import com.martin.school_student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO save(StudentRequestDTO student) {
        // 1. Retrieve a DTO and convert it to entity.
        Student convertedStudent = StudentDTOMapper.fromDTO(student);

        // 2. Persist the converted Student in the database.
        Student savedStudent = studentRepository.save(convertedStudent);

        // 3. Convert the Student entity to DTO for response.
        return StudentDTOMapper.toDTO(savedStudent);
    }
}
