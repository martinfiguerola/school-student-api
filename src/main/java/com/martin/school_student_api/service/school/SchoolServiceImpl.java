package com.martin.school_student_api.service.school;

import com.martin.school_student_api.domain.School;
import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;
import com.martin.school_student_api.mapper.school.SchoolDTOMapper;
import com.martin.school_student_api.repository.SchoolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Transactional
    @Override
    public SchoolResponseDTO save(SchoolRequestDTO schoolRequestDTO) {
        // 1. Retrieve the DTO and convert it into an entity for persistence.
        School transformedSchoolEntity = SchoolDTOMapper.fromDTO(schoolRequestDTO);
        // 2. Persist the transformed entity in the database.
        School savedSchool = schoolRepository.save(transformedSchoolEntity);
        // 3. Convert the saved entity to a DTO for the response.
        return SchoolDTOMapper.toDTO(savedSchool);
    }
}
