package com.martin.school_student_api.service.school;


import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;

public interface SchoolService {

    SchoolResponseDTO save (SchoolRequestDTO schoolRequestDTO);
}
