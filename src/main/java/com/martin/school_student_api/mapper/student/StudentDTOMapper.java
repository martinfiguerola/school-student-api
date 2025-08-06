package com.martin.school_student_api.mapper.student;

import com.martin.school_student_api.domain.Student;
import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;

public class StudentDTOMapper {

    public static Student fromDTO (StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setFirstname(studentRequestDTO.getFirstname());
        student.setLastname(studentRequestDTO.getLastname());
        student.setEmail(studentRequestDTO.getEmail());
        return student;
    }

    public static StudentResponseDTO toDTO (Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setFirstname(student.getFirstname());
        studentResponseDTO.setLastname(student.getLastname());
        studentResponseDTO.setEmail(student.getEmail());
        return studentResponseDTO;
    }
}
