package com.martin.school_student_api.mapper.school;

import com.martin.school_student_api.domain.School;
import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;

public class SchoolDTOMapper {

    public static School fromDTO (SchoolRequestDTO schoolRequestDTO) {

        School school = new School();
        school.setName(schoolRequestDTO.getName());
        school.setAddress(schoolRequestDTO.getAddress());
        school.setPhone(schoolRequestDTO.getPhone());

        return school;
    }

    public static SchoolResponseDTO toDTO (School school) {

        SchoolResponseDTO schoolResponseDTO = new SchoolResponseDTO();
        schoolResponseDTO.setId(school.getId());
        schoolResponseDTO.setName(school.getName());
        schoolResponseDTO.setAddress(school.getAddress());
        schoolResponseDTO.setPhone(school.getPhone());

        return schoolResponseDTO;
    }
}
