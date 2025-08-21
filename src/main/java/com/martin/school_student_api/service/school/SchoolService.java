package com.martin.school_student_api.service.school;


import com.martin.school_student_api.dto.school.SchoolDetailDTO;
import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    SchoolResponseDTO save (SchoolRequestDTO schoolRequestDTO);
    Optional<SchoolResponseDTO> update (Long id, SchoolRequestDTO schoolRequestDTO);
    Page<SchoolResponseDTO> findAll (Pageable pageable);
    Optional<SchoolDetailDTO> findById (Long id);
    Boolean delete (Long id);

}
