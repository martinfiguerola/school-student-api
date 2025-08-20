package com.martin.school_student_api.mapper.school;

import com.martin.school_student_api.domain.School;
import com.martin.school_student_api.dto.school.SchoolDetailDTO;
import com.martin.school_student_api.dto.school.SchoolRequestDTO;
import com.martin.school_student_api.dto.school.SchoolResponseDTO;
import com.martin.school_student_api.dto.student.StudentRefDTO;
import com.martin.school_student_api.mapper.student.StudentDTOMapper;

import java.util.List;

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

    public static SchoolDetailDTO toSchoolDetailDTO (School school) {
        SchoolDetailDTO schoolDetailDTO = new SchoolDetailDTO();

        schoolDetailDTO.setId(school.getId());
        schoolDetailDTO.setName(school.getName());
        schoolDetailDTO.setAddress(school.getAddress());
        schoolDetailDTO.setPhone(school.getPhone());

        // Convertimos a una lista de student RefsDTOs
        List<StudentRefDTO> studentRefDTOS = school.getStudents().stream()
                        .map(StudentDTOMapper::toRefDTO)
                        .toList();

        schoolDetailDTO.setStudents(studentRefDTOS);

        return schoolDetailDTO;
    }
}
