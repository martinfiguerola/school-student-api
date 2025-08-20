package com.martin.school_student_api.mapper.student;

import com.martin.school_student_api.domain.Student;
import com.martin.school_student_api.dto.school.SchoolRefDTO;
import com.martin.school_student_api.dto.student.StudentDetailDTO;
import com.martin.school_student_api.dto.student.StudentRefDTO;
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

    public static StudentDetailDTO toDTOWithSchool (Student student) {
        StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
        SchoolRefDTO schoolRefDTO = new SchoolRefDTO();

        schoolRefDTO.setId(student.getSchool().getId());
        schoolRefDTO.setName(student.getSchool().getName());

        studentDetailDTO.setId(student.getId());
        studentDetailDTO.setFirstname(student.getFirstname());
        studentDetailDTO.setLastname(student.getLastname());
        studentDetailDTO.setEmail(student.getEmail());

        studentDetailDTO.setSchool(schoolRefDTO);

        return studentDetailDTO;

    }

    public static StudentResponseDTO toDTO (Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setFirstname(student.getFirstname());
        studentResponseDTO.setLastname(student.getLastname());
        studentResponseDTO.setEmail(student.getEmail());
        return studentResponseDTO;
    }

    public static StudentRefDTO toRefDTO (Student student) {
        StudentRefDTO studentRefDTO = new StudentRefDTO();
        studentRefDTO.setId(student.getId());
        studentRefDTO.setFirstname(student.getFirstname());
        return studentRefDTO;
    }
}
