package com.martin.school_student_api.service.student;

import com.martin.school_student_api.domain.Student;
import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;
import com.martin.school_student_api.mapper.student.StudentDTOMapper;
import com.martin.school_student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    @Override
    public StudentResponseDTO save(StudentRequestDTO student) {
        // Validate email uniqueness
        if (studentRepository.existsByEmail(student.getEmail())){
            throw new IllegalArgumentException("There is already a student with that email address: " + student.getEmail());
        }

        // 2. Retrieve a DTO and convert it to entity.
        Student convertedStudent = StudentDTOMapper.fromDTO(student);

        // 3. Persist the converted Student in the database.
        Student savedStudent = studentRepository.save(convertedStudent);

        // 4. Convert the Student entity to DTO for response.
        return StudentDTOMapper.toDTO(savedStudent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentResponseDTO> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentDTOMapper::toDTO)
                .toList();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<StudentResponseDTO> findById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(StudentDTOMapper::toDTO);
    }

    @Transactional
    @Override
    public Optional<StudentResponseDTO> update(Long id, StudentRequestDTO studentRequestDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        return optionalStudent.map(student -> {
            student.setFirstname(studentRequestDTO.getFirstname());
            student.setLastname(studentRequestDTO.getLastname());
            student.setEmail(studentRequestDTO.getEmail());

            Student updatedStudent = studentRepository.save(student);

            return StudentDTOMapper.toDTO(updatedStudent);
        });
    }

    @Transactional
    @Override
    public Boolean delete(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        return optionalStudent
                .map(student -> {
                    studentRepository.delete(student);
                    return true;
                })
                .orElse(false);
    }
}
