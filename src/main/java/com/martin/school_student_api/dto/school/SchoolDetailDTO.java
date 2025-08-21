package com.martin.school_student_api.dto.school;

import com.martin.school_student_api.domain.Student;
import com.martin.school_student_api.dto.student.StudentRefDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SchoolDetailDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private List<StudentRefDTO> students = new ArrayList<>();
}
