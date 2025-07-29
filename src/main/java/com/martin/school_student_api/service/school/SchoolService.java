package com.martin.school_student_api.service.school;


import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    SchoolResponseDTO save (SchoolRequestDTO schoolRequestDTO);
    Optional<SchoolResponseDTO> update (Long id, SchoolRequestDTO schoolRequestDTO);
    List<SchoolResponseDTO> findAll ();
}
