package com.martin.school_student_api.service.student;

import com.martin.school_student_api.domain.School;
import com.martin.school_student_api.domain.Student;
import com.martin.school_student_api.dto.student.StudentDetailDTO;
import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;
import com.martin.school_student_api.mapper.student.StudentDTOMapper;
import com.martin.school_student_api.repository.SchoolRepository;
import com.martin.school_student_api.repository.StudentRepository;
import com.martin.school_student_api.service.school.SchoolService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentServiceImpl(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @Transactional
    @Override
    public StudentResponseDTO save(StudentRequestDTO student) {

        // Step 1: Validate email uniqueness
        if (studentRepository.existsByEmail(student.getEmail())){
            throw new IllegalArgumentException("There is already a student with that email address: " + student.getEmail());
        }

        // Step 2: Retrieve the School ID using the school attributes from the student
        Long schoolId = student.getSchool();

        // Step 3: Convert the incoming DTO to a School entity (without the school entity yet)
        Student convertedStudent = StudentDTOMapper.fromDTO(student);

        // Step 4: .orElseThrow() to handle the case where the school does not exist
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(()-> new IllegalArgumentException("School with: " + schoolId + " does not exist."));


        // Step 5: Assign the retrieve School entity to the Student entity.
        convertedStudent.setSchool(school);

        // Step 6: Persist the converted Student in the database.
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
    public Optional<StudentDetailDTO> findById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(StudentDTOMapper::toDTOWithSchool);
    }

    @Transactional
    @Override
    public Optional<StudentResponseDTO> update(Long id, StudentRequestDTO studentRequestDTO) {

        Optional<Student> optionalStudent = studentRepository.findById(id);



        return optionalStudent.map(student -> {

            student.setFirstname(studentRequestDTO.getFirstname());
            student.setLastname(studentRequestDTO.getLastname());
            student.setEmail(studentRequestDTO.getEmail());

            // 1. Save the school ID using the school attributes from the studentRequestDTO
            Long schoolId = studentRequestDTO.getSchool();

            // 2. .orElseThrow() to handle the case where the school does not exist
            School school = schoolRepository.findById(schoolId)
                            .orElseThrow(()-> new IllegalArgumentException("School with: " + schoolId + " does not exist."));

            // Step 5: Assign the retrieve School entity to the Student entity.
            student.setSchool(school);

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
