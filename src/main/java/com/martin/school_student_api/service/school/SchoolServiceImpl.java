package com.martin.school_student_api.service.school;

import com.martin.school_student_api.domain.School;
import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;
import com.martin.school_student_api.mapper.school.SchoolDTOMapper;
import com.martin.school_student_api.repository.SchoolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public Optional<SchoolResponseDTO> update(Long id, SchoolRequestDTO schoolRequestDTO) {
        // Step 1: Fetches a School entity by its ID from the database
        Optional<School> optionalSchool = schoolRepository.findById(id);

        // Step 1:  If the School exists, update its fields, save the changes and convert to DTO.
        // Otherwise, the method will return an empty Optional.
        return optionalSchool.map(school -> {
            school.setName(schoolRequestDTO.getName());
            school.setAddress(schoolRequestDTO.getAddress());
            school.setPhone(schoolRequestDTO.getPhone());

            School savedSchool = schoolRepository.save(school);

            return SchoolDTOMapper.toDTO(savedSchool);
        });
    }

    @Transactional(readOnly = true)
    @Override
    public List<SchoolResponseDTO> findAll() {
        // 1. Retrieve all category entities from the database
        List<School> schools = schoolRepository.findAll();
        // 2. Convert each entity to DTO and return it
        return schools.stream()
                .map(SchoolDTOMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<SchoolResponseDTO> findById(Long id) {
        // 1. Fetches a School entity by its ID from the database.
        Optional<School> optionalSchool = schoolRepository.findById(id);

        // 2. If the School exists, convert it to DTO and return it
        // Otherwise, the method will return an empty Optional.
        return optionalSchool.map(SchoolDTOMapper::toDTO);
    }

    @Override
    public Boolean delete(Long id) {
        // 1. Fetches a School entity by its ID from the database.
        Optional<School> optionalSchool = schoolRepository.findById(id);

        // 2. If the School exists, delete it and return true;
        // Otherwise, return false.
        return optionalSchool.map(school -> {
            schoolRepository.delete(school);
            return true;
        }).orElse(false);
    }
}
