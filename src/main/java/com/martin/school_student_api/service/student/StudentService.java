package com.martin.school_student_api.service.student;


import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO save (StudentRequestDTO student);
}
