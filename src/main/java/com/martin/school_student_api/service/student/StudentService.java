package com.martin.school_student_api.service.student;


import com.martin.school_student_api.dto.student.StudentDetailDTO;
import com.martin.school_student_api.dto.student.StudentRequestDTO;
import com.martin.school_student_api.dto.student.StudentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentResponseDTO save (StudentRequestDTO student);
    List<StudentResponseDTO> findAll ();
    Optional<StudentDetailDTO> findById (Long id);
    Optional<StudentResponseDTO> update (Long id, StudentRequestDTO studentRequestDTO);
    Boolean delete (Long id);
}
